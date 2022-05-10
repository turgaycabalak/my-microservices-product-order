package com.mymicro.order.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "order_line_items")
@NoArgsConstructor
public class OrderLineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;


    public OrderLineItem(String skuCode,
                         BigDecimal price,
                         Integer quantity) {
        this.skuCode = skuCode;
        this.price = price;
        this.quantity = quantity;
    }
}
