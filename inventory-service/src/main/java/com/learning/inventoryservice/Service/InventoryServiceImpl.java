package com.learning.inventoryservice.Service;

import com.learning.inventoryservice.dao.InventoryRepository;
import com.learning.inventoryservice.entity.Inventory;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@org.springframework.transaction.annotation.Transactional
public class InventoryServiceImpl implements InventoryService{
    @Autowired
    private final InventoryRepository inventoryRepository;

    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Optional<Inventory> isInStock(String skuCode) {

        return  inventoryRepository.findInventoryBySkuCode(skuCode);
    }
}
