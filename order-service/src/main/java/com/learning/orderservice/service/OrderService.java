package com.learning.orderservice.service;

import com.learning.orderservice.dto.OrderRequest;
import org.springframework.web.bind.annotation.RequestBody;

public interface OrderService {

    public void placeOrder(@RequestBody OrderRequest orderRequest);
}
