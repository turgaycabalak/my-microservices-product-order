package com.mymicro.inventory.dataAccess;

import com.mymicro.inventory.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    List<Inventory> findBySkuCodeIn(List<String> skuCodes);

}
