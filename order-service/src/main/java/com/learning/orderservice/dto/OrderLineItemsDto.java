package com.learning.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderLineItemsDto {

    private Long id;
    private String skuCode;
    private Long price;
    private Integer quantity;

}
