package com.learning.orderservice.service;

import com.learning.orderservice.dao.OrderRepository;
import com.learning.orderservice.dto.InventoryResponse;
import com.learning.orderservice.dto.OrderLineItemsDto;
import com.learning.orderservice.dto.OrderRequest;
import com.learning.orderservice.entity.Order;
import com.learning.orderservice.entity.OrderLineItems;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

    @Autowired
    private final OrderRepository orderRepository;
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Autowired
    private WebClient webClient;

    //here mapping order_line_item_dto from OrderRequest to order_line_item & then set to orderLineItemList
    @Override
    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems =orderRequest.getOrderLineItemsDtoList()
                .stream()
                //.map(orderLineItemsDto -> mapToDto(orderLineItemsDto)); or
                .map(this::mapToDto)
                .collect(Collectors.toList());

        order.setOrderLineItemsList(orderLineItems);

        List<String> skuCodes = order.getOrderLineItemsList().stream()
                //OrderLineItems->OrderLineItems.getSkuCode()
                .map(OrderLineItems::getSkuCode)
                .toList();

        //call to inventory service to check inventory availability for order place
        InventoryResponse[] inventoryResponsesArray = webClient.get()
                .uri("http://localhost:8089/api/inventory/",
                        uriBuilder -> uriBuilder.queryParam("skuCodes",skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

       boolean allProductsInStock = Arrays.stream(inventoryResponsesArray).allMatch(inventoryResponse -> inventoryResponse.isInStock());

        if(allProductsInStock) {
            orderRepository.save(order);
        }else {
            throw new IllegalArgumentException("Product is not in stock , please try again later");
        }
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        return orderLineItems;
    }


}
