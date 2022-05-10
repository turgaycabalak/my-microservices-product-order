package com.mymicro.product.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "products")
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String description;
    private BigDecimal price;


    public Product(String productName,
                   String description,
                   BigDecimal price) {
        this.productName = productName;
        this.description = description;
        this.price = price;
    }
}
