package com.mymicro.order.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLineItem> orderLineItems;


    public Order(String orderNumber,
                 List<OrderLineItem> orderLineItems) {
        this.orderNumber = orderNumber;
        this.orderLineItems = orderLineItems;
    }
}
