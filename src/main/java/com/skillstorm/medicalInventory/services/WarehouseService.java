package com.skillstorm.medicalInventory.services;

import com.skillstorm.medicalInventory.model.Warehouse;
import com.skillstorm.medicalInventory.repositories.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {

    @Autowired
    WarehouseRepository warehouseRepository;
    public List<Warehouse> findAll() {
        return warehouseRepository.findAll();
    }
    public Warehouse findById(int id) {
        System.out.println(id);
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        if(optionalWarehouse.isPresent()) {
          return optionalWarehouse.get();
        }
        return null;
    }

    public Warehouse saveWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    public void deleteWarehouse(int warehouseId) {
        warehouseRepository.deleteById(warehouseId);
    }

}
