package com.example.actioneer.service.scraper;

import com.example.actioneer.model.Item;

public abstract class Scraper {
    public abstract double getPrice(String url);

//    public boolean isOnSale(Item item){
//        return (item.getOriginalPrice() < getPrice(item.getURL()));
//    }
}
