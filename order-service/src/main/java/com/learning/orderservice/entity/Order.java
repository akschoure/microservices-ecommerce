package com.learning.orderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order_table")
public class Order {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    @Column
    private String orderNumber;
    @Column
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLineItems> orderLineItemsList;



}
