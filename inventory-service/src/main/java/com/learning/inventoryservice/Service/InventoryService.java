package com.learning.inventoryservice.Service;

import com.learning.inventoryservice.dto.InventoryResponse;
import com.learning.inventoryservice.entity.Inventory;

import java.util.List;
import java.util.Optional;

public interface InventoryService {
    List<InventoryResponse> isInStock(List<String> skuCode);
}
