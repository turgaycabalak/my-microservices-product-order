package com.mymicro.inventory.api.controller;

import com.mymicro.inventory.business.InventoryService;
import com.mymicro.inventory.eDto.InventoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/inventories")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    //localhost:9003/api/v1/inventories?skuCode=iphone_13&skuCode=iphone_13_red
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam("skuCode") List<String> skuCodes){
        return inventoryService.isInStock(skuCodes);
    }


}
