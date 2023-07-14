package com.skillstorm.medicalInventory.services;

import com.skillstorm.medicalInventory.model.Inventory;
import com.skillstorm.medicalInventory.model.Warehouse;
import com.skillstorm.medicalInventory.repositories.InventoryRepository;
import com.skillstorm.medicalInventory.repositories.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {

    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    InventoryRepository inventoryRepository;

    public List<Warehouse> findAll() {
        return warehouseRepository.findAll();
    }
    public Warehouse findById(int id) {
        System.out.println(id);
        // Find warehouse by id and unwrap Optional
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        if(optionalWarehouse.isPresent()) {
          return optionalWarehouse.get();
        }
        return null;
    }

    public Warehouse saveWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    public ResponseEntity<String> deleteWarehouse(int warehouseId) {

        Warehouse warehouse = findById(warehouseId);

        //Find all Inventory in Warehouse and delete them before deleting warehouse
        List<Inventory> inventoryList = inventoryRepository.findByWarehouse(warehouse);
        inventoryRepository.deleteAll(inventoryList);
        warehouseRepository.deleteById(warehouseId);

        return ResponseEntity.ok("Warehouse Deleted");
    }

}
