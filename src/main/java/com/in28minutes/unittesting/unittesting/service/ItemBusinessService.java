package com.in28minutes.unittesting.unittesting.service;

import java.util.List;

import com.in28minutes.unittesting.unittesting.data.ItemRepository;
import com.in28minutes.unittesting.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemBusinessService {

    @Autowired
    ItemRepository repository;

    public Item retrieveHardCodeItem() {
        return new Item(1, "Ball", 10, 100);
    }

    public List<Item> retrieveAllItems() {
        List<Item> items = repository.findAll();
        for (Item item : items) {
            item.setValue(item.getPrice() * item.getQuantity());
        }

        return items;
    }
}
