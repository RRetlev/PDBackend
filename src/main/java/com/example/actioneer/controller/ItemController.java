package com.example.actioneer.controller;


import com.example.actioneer.model.Item;
import com.example.actioneer.service.ItemService;
import com.example.actioneer.service.scraper.SaleValidator;
import com.example.actioneer.service.scraper.dedicated.AmazonScraper;
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

    @Autowired
    AmazonScraper amazonScraper;

    @Autowired
    SaleValidator saleValidator;


    @PostMapping("/new")
    public Item saveNewItem(@RequestBody Item item){
        return itemService.addNewItem(item);
    }
}
