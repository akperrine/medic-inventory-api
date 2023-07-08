package com.skillstorm.medicalInventory.dtos;

import org.springframework.stereotype.Component;

@Component
public class InventoryDto {
    private int warehouseId;

    private int itemId;
    private String itemName;
    private int quantity;
    private int maxCapacity;

    public InventoryDto() {}
    public InventoryDto(int warehouseId, int itemId, String itemName, int quantity, int maxCapacity) {
        this.warehouseId = warehouseId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.maxCapacity = maxCapacity;
    }

    public InventoryDto(int warehouseId, String itemName, int quantity, int maxCapacity) {
        this.warehouseId = warehouseId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.maxCapacity = maxCapacity;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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
        return "InventoryDto{" +
                "warehouseId=" + warehouseId +
                ", itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", maxCapacity=" + maxCapacity +
                '}';
    }
}