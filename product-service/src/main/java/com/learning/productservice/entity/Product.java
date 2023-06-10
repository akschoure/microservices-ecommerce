package com.learning.productservice.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column
    private String id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private long price;



}
