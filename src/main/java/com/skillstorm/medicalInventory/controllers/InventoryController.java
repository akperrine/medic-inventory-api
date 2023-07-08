package com.skillstorm.medicalInventory.controllers;

import com.skillstorm.medicalInventory.dtos.InventoryDto;
import com.skillstorm.medicalInventory.services.InventoryService;
import com.skillstorm.medicalInventory.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<List<Inventory>> findAllInventory() {
        List<Inventory> inventories =  inventoryService.findAll();

        return new ResponseEntity<List<Inventory>>(inventories, HttpStatus.OK);
    }

    @PostMapping
    public void createInventory(@RequestBody InventoryDto inventoryDto) {
        inventoryService.createInventory(inventoryDto);
    }
}
