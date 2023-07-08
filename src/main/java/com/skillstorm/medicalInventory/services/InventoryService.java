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

    private boolean checkQuantityBelowCapcity(int quantity, int capacity) {
        return quantity <= capacity;
    }

    public List<Inventory> findAll() {
        return inventoryRepository.findAll();
    }

    public Inventory createInventory(InventoryDto inventoryDto) {
        String itemName = inventoryDto.getItemName();
        int warehouseId = inventoryDto.getWarehouseId();
        if(!checkQuantityBelowCapcity(inventoryDto.getQuantity(), inventoryDto.getMaxCapacity())) {
            // implement an error for if quantit
            return null;
        }


        Warehouse warehouse = warehouseService.findById(warehouseId);
        if(warehouse == null) return null;

        // Initialize new Inventory and PK id class
        InventoryPK inventoryPK = new InventoryPK();
        Inventory newInventory = new Inventory();

        Item foundItem = itemService.getItemByName(itemName);
        if (foundItem == null) {
            Item newItem = new Item(itemName);
            itemService.saveItem(newItem);
            foundItem = newItem;
        }

        // Set PK made of composite Key
        inventoryPK.setItem(foundItem.getItemId());
        inventoryPK.setWarehouse(warehouseId);

        // Set the new Inventory
        System.out.println(inventoryDto.getMaxCapacity());
        newInventory.setItem(foundItem);
        newInventory.setWarehouse(warehouse);
        newInventory.setQuantity(inventoryDto.getQuantity());
        newInventory.setMaxCapacity(inventoryDto.getMaxCapacity());

        return inventoryRepository.save(newInventory);
    }

    public Inventory updateInventory(int itemId, InventoryDto inventoryDto) {
        //Create PK from the Composite key class;
        InventoryPK inventoryPK = new InventoryPK(itemId, inventoryDto.getWarehouseId());

        if(!checkQuantityBelowCapcity(inventoryDto.getQuantity(), inventoryDto.getMaxCapacity())) {
            // implement an error for if quantity
            System.out.println("inappropriate quantity");
            return null;
        }

        // Retrieve the inventory that will be updated
        Inventory inventoryToUpdate = inventoryRepository.findById(inventoryPK).orElse(null);
        if (inventoryToUpdate == null) return null;

        // Update the inventory
        inventoryToUpdate.setQuantity(inventoryDto.getQuantity());
        inventoryToUpdate.setMaxCapacity(inventoryDto.getMaxCapacity());

        // save the updated inventory and return
        return inventoryRepository.save(inventoryToUpdate);
    }

    public Inventory deleteInventory(int itemId, int warehouseId) {
        InventoryPK inventoryPK = new InventoryPK(itemId, warehouseId);

        System.out.println(inventoryPK.toString());
        Inventory inventoryToDelete = inventoryRepository.findById(inventoryPK).orElse(null);
        if (inventoryToDelete == null) return null;

        inventoryRepository.delete(inventoryToDelete);
        return inventoryToDelete;
    }
}
