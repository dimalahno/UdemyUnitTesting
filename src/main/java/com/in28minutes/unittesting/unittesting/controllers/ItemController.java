package com.in28minutes.unittesting.unittesting.controllers;

import java.util.List;

import com.in28minutes.unittesting.unittesting.model.Item;
import com.in28minutes.unittesting.unittesting.service.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    ItemBusinessService businessService;

    @GetMapping("/dummy-item")
    public Item dummyItem() {
        return new Item(1, "Ball", 10, 100);
    }

    @GetMapping("/item-from-service")
    public Item itemFromService() {
        return businessService.retrieveHardCodeItem();
    }

    @GetMapping("/all-items-from-database")
    public List<Item> allItemsFromDatabase() {
        return businessService.retrieveAllItems();
    }
}
