package com.mymicro.inventory.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "inventories")
@NoArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private Integer quantity;


    public Inventory(String skuCode,
                     Integer quantity) {
        this.skuCode = skuCode;
        this.quantity = quantity;
    }
}
