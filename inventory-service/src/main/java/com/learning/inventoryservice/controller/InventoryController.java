package com.learning.inventoryservice.controller;

import com.learning.inventoryservice.Service.InventoryService;
import com.learning.inventoryservice.Service.InventoryServiceImpl;
import com.learning.inventoryservice.dto.InventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    private final InventoryServiceImpl inventoryServiceImpl;
    public InventoryController(InventoryServiceImpl inventoryServiceImpl) {
        this.inventoryServiceImpl = inventoryServiceImpl;
    }

    @GetMapping
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCodes){
          return inventoryServiceImpl.isInStock(skuCodes);
    }
}
