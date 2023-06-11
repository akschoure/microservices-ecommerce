package com.learning.inventoryservice.dao;

import com.learning.inventoryservice.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface InventoryRepository  extends JpaRepository<Inventory,Long> {
    //Optional<Inventory> findInventoryBySkuCode(String skuCode);
    List<Inventory>findBySkuCodeIn(List<String> skuCode);

}
