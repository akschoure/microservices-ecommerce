package com.learning.orderservice.controller;

import com.learning.orderservice.dto.OrderRequest;
import com.learning.orderservice.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private final OrderServiceImpl orderService;
    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String placeOrder(@RequestBody OrderRequest orderRequest){
         orderService.placeOrder(orderRequest);
        return "Order place success full";
    }

}
