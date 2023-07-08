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
    public ResponseEntity<Inventory> createInventory(@RequestBody InventoryDto inventoryDto) {
        System.out.println(inventoryDto.toString());
        Inventory newInventory = inventoryService.createInventory(inventoryDto);

        try {
            return new ResponseEntity<>(newInventory, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Controller to Edit Inventory/ Update the count
    @PutMapping("/{itemId}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable int itemId, @RequestBody InventoryDto inventoryDto) {
        Inventory updatedInventory = inventoryService.updateInventory( itemId, inventoryDto);

        try {
            return new ResponseEntity<>(updatedInventory, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{itemId}/{warehouseId}")
    public ResponseEntity<Inventory> deleteInventory(@PathVariable int itemId, @PathVariable int warehouseId) {
        Inventory deletedInventory = inventoryService.deleteInventory(itemId, warehouseId);
        try {
            return new ResponseEntity<>(deletedInventory, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
