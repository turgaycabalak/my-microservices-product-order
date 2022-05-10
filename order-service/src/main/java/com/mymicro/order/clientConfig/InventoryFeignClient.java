package com.mymicro.order.clientConfig;

import com.mymicro.order.entities.InventoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "inventory", url = "http://localhost:9003/api/v1/inventories")
public interface InventoryFeignClient {

    @GetMapping
    List<InventoryResponse> isInStock(@RequestParam("skuCode") List<String> skuCodes);
}
