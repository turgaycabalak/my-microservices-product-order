package com.mymicro.product.eDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Long id;
    private String productName;
    private String description;
    private BigDecimal price;
}
