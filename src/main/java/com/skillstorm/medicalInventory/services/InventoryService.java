package com.skillstorm.medicalInventory.services;

import com.skillstorm.medicalInventory.dtos.InventoryDto;
import com.skillstorm.medicalInventory.model.Inventory;
import com.skillstorm.medicalInventory.model.InventoryPK;
import com.skillstorm.medicalInventory.model.Item;
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


    public List<Inventory> findAll() {
        return inventoryRepository.findAll();
    }

    public void createInventory(InventoryDto inventoryDto) {
        InventoryPK inventoryPK = new InventoryPK();
        Inventory newInventory = new Inventory();

        Item foundItem = itemService.getItemByName(inventoryDto.getItemName());
        if (foundItem == null) {
            System.out.println("no item");
        } else {
            System.out.println(foundItem.toString());
        }

    }
}
