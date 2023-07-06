package com.skillstorm.medicalInventory.controllers;

import com.skillstorm.medicalInventory.model.Warehouse;
import com.skillstorm.medicalInventory.services.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    WarehouseService warehouseService;

    @GetMapping
    public ResponseEntity<List<Warehouse>> findAllWarehouses() {
        List<Warehouse> warehouses = warehouseService.findAll();
        return new ResponseEntity<>(warehouses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> findSingleWarehouse(@PathVariable("id") int id) {
        Warehouse warehouse = warehouseService.findById(id);
        return new ResponseEntity<>(warehouse, HttpStatus.OK);
    }

    @PostMapping
    public  ResponseEntity<Warehouse> createWarehouse(@RequestBody Warehouse warehouse) {
        System.out.println(warehouse.toString());
        Warehouse newWarehouse = warehouseService.saveWarehouse(warehouse);
        return new ResponseEntity<>(newWarehouse, HttpStatus.OK);
    }

    @PutMapping()
    public  ResponseEntity<Warehouse> updateWarehouse(@RequestBody Warehouse warehouse) {
        System.out.println(warehouse.toString());
        Warehouse newWarehouse = warehouseService.saveWarehouse(warehouse);
        return new ResponseEntity<>(newWarehouse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{warehouseId}")
    public ResponseEntity<Warehouse> deleteWarehouse(@PathVariable("warehouseId") int id) {
        warehouseService.deleteWarehouse(id);
        return new ResponseEntity<Warehouse>(HttpStatus.NO_CONTENT);
    }
}
