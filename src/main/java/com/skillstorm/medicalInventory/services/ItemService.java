package com.skillstorm.medicalInventory.services;

import com.skillstorm.medicalInventory.model.Item;
import com.skillstorm.medicalInventory.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public Item getItemByName(String name) {
        Item foundItem = itemRepository.findByItemName(name);
        return foundItem;
    }
}
