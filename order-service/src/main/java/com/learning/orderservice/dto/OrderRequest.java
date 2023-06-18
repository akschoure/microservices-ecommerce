package com.learning.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class OrderRequest {

    private List<OrderLineItemsDto> orderLineItemsDtoList;
}
