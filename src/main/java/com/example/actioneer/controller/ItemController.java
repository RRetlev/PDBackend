package com.example.actioneer.controller;


import com.example.actioneer.model.Item;
import com.example.actioneer.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ItemController {

    @Autowired
    ItemService itemService;
    
    @PostMapping("/new")
    public Item saveNewItem(@RequestBody Item item){
        return itemService.addNewItem(item);
    }

    @GetMapping("/")
    public String ImHereJustForThePing(){
        return"Heroku is up and running";
    }
}
