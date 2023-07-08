package com.skillstorm.medicalInventory.services;

import com.skillstorm.medicalInventory.dtos.InventoryDto;
import com.skillstorm.medicalInventory.model.Inventory;
import com.skillstorm.medicalInventory.model.InventoryPK;
import com.skillstorm.medicalInventory.model.Item;
import com.skillstorm.medicalInventory.model.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.skillstorm.medicalInventory.repositories.InventoryRepository;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    ItemService itemService;
    @Autowired
    WarehouseService warehouseService;


    public List<Inventory> findAll() {
        return inventoryRepository.findAll();
    }

    public void createInventory(InventoryDto inventoryDto) {
        String itemName = inventoryDto.getItemName();
        int warehouseId = inventoryDto.getWarehouseId();
        Warehouse warehouse = warehouseService.findById(warehouseId);
        if(warehouse == null) return;

        // Initialize new Inventory and PK id class
        InventoryPK inventoryPK = new InventoryPK();
        Inventory newInventory = new Inventory();

        Item foundItem = itemService.getItemByName(itemName);
        if (foundItem == null) {
            Item newItem = new Item(itemName);
            itemService.saveItem(newItem);
            foundItem = newItem;
            System.out.println("heres the new item: "+ foundItem.toString());
        }

        // Set PK made of composite Key
        inventoryPK.setItem(foundItem.getItemId());
        inventoryPK.setWarehouse(warehouseId);
        System.out.println(inventoryPK.toString());

        // Set the new Inventory
        newInventory.setItem(foundItem);
        newInventory.setWarehouse(warehouse);
        newInventory.setQuantity(inventoryDto.getQuantity());
        newInventory.setMaxCapacity(inventoryDto.getMaxCapacity());

        inventoryRepository.save(newInventory);
        System.out.println(newInventory.toString());
    }
}
