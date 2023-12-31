package com.skillstorm.medicalInventory.services;

import com.skillstorm.medicalInventory.model.Item;
import com.skillstorm.medicalInventory.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public List<Item> findAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemByName(String name) {
        // Checks for Item
        Item foundItem = itemRepository.findByItemName(name);
        return foundItem;
    }

    public Item saveItem(Item item) {return itemRepository.save(item);}
}
