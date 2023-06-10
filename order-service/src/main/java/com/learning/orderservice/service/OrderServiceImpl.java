package com.learning.orderservice.service;

import com.learning.orderservice.dao.OrderRepository;
import com.learning.orderservice.dto.OrderLineItemsDto;
import com.learning.orderservice.dto.OrderRequest;
import com.learning.orderservice.entity.Order;
import com.learning.orderservice.entity.OrderLineItems;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    //here mapping orderlineitemdto from OrderRequest to orderlineitem & then set to orderLineItemList
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

        orderRepository.save(order);
                
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        return orderLineItems;
    }


}
