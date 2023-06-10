package com.learning.orderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order_line_items")
public class OrderLineItems {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String skuCode;
    @Column
    private Long price;
    @Column
    private Integer quantity;
//    @Column
//    @ManyToOne
//    private Order order;

}
