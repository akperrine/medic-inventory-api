package com.skillstorm.medicalInventory.model;

import java.io.Serializable;
import java.util.Objects;

public class InventoryPK implements Serializable {
    private int item;
    private int warehouse;

    public InventoryPK() {}

    public InventoryPK(int itemId, int warehouseId) {
        this.item = itemId;
        this.warehouse = warehouseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryPK that = (InventoryPK) o;
        return item == that.item && warehouse == that.warehouse;
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, warehouse);
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(int warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public String toString() {
        return "InventoryPK{" +
                "item=" + item +
                ", warehouse=" + warehouse +
                '}';
    }
}
