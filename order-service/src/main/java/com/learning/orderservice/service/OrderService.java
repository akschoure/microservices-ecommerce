package com.learning.orderservice.service;

import com.learning.orderservice.dto.OrderRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public interface OrderService {

    public void placeOrder(@RequestBody OrderRequest orderRequest);
}
