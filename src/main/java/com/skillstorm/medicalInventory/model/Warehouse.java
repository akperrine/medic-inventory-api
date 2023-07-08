package com.skillstorm.medicalInventory.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "warehouse")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_id")
    private int warehouseId;

    @Column(name = "location")
    private String location;

    @JsonBackReference
    @OneToMany(targetEntity = Inventory.class, mappedBy = "warehouse")
    private List<Inventory> warehouseInventory;

    public Warehouse() {

    }
    public Warehouse(String location) {
        this.location = location;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Inventory> getWarehouseItems() {
        return warehouseInventory;
    }

    public void setWarehouseItems(List<Inventory> warehouseInventory) {
        this.warehouseInventory = warehouseInventory;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "warehouseId=" + warehouseId +
                ", location='" + location + '\'' +
                ", warehouseInventory=" + warehouseInventory +
                '}';
    }
}
