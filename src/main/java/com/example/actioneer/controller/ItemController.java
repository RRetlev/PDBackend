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
    
    @PostMapping("/item")
    public Item saveNewItem(@RequestBody Item item){
        return itemService.addNewItem(item);
    }

//    @PutMapping("/item")
//    public Item updateItemPrice(){
//        return itemService.updateItemPrice();
//    }

    @DeleteMapping("/item")
    public Item deleteItem(){
        return itemService.deleteItem();
    }

    @GetMapping("/")
    public String ImHereJustForThePing(){
        return"Heroku is up and running";
    }
}
