package com.learning.orderservice.service;

import com.learning.orderservice.dto.OrderRequest;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
    @Override
    public void placeOrder(OrderRequest orderRequest) {
        
    }
}
