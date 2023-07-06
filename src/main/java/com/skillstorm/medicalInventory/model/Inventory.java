package com.skillstorm.medicalInventory.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "inventory")
@IdClass(InventoryPK.class)
public class Inventory {

    @Id
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Id
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "max_capacity")
    private int maxCapacity;

    public Inventory() {}
    public Inventory(Item item, Warehouse warehouse, int quantity, int maxCapacity) {
        this.item = item;
        this.warehouse = warehouse;
        this.quantity = quantity;
        this.maxCapacity = maxCapacity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public String toString() {
        return "Inventory{" +
//                "item=" + item +
//                ", warehouse=" + warehouse +
                ", quantity=" + quantity +
                ", maxCapacity=" + maxCapacity +
                '}';
    }
}
