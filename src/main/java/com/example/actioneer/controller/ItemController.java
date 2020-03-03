package com.example.actioneer.controller;


import com.example.actioneer.model.Item;
import com.example.actioneer.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ItemController {

    @Autowired
    ItemService itemService;
    
    @PostMapping("/new")
    public Item saveNewItem(@RequestBody Item item){
        return itemService.addNewItem(item);
    }
}
