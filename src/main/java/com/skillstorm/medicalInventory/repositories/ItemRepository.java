package com.skillstorm.medicalInventory.repositories;

import com.skillstorm.medicalInventory.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
        Item findByItemName(String itemName);
}
