package com.learning.inventoryservice.controller;

import com.learning.inventoryservice.Service.InventoryService;
import com.learning.inventoryservice.Service.InventoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    private final InventoryServiceImpl inventoryServiceImpl;
    public InventoryController(InventoryServiceImpl inventoryServiceImpl) {
        this.inventoryServiceImpl = inventoryServiceImpl;
    }

    @GetMapping("/{sku-code}")
    public boolean isInStock(@PathVariable(name = "sku-code") String skuCode){
          return inventoryServiceImpl.isInStock(skuCode).isPresent();
    }
}
