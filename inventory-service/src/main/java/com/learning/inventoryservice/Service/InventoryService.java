package com.learning.inventoryservice.Service;

import com.learning.inventoryservice.entity.Inventory;

import java.util.Optional;

public interface InventoryService {
    Optional<Inventory> isInStock(String skuCode);
}
