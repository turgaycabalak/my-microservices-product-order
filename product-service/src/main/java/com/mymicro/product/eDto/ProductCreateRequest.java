package com.mymicro.product.eDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateRequest {
    private String productName;
    private String description;
    private BigDecimal price;
}
