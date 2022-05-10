package com.mymicro.inventory.business;

import com.mymicro.inventory.dataAccess.InventoryRepository;
import com.mymicro.inventory.eDto.InventoryResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;


    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCodes) {
        return inventoryRepository.findBySkuCodeIn(skuCodes).stream()
                .map(inventory -> new InventoryResponse(
                        inventory.getSkuCode(),
                        inventory.getQuantity() > 0
                )).toList();
    }
}
