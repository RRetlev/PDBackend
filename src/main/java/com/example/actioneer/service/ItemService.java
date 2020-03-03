package com.example.actioneer.service;

import com.example.actioneer.model.Item;
import com.example.actioneer.repository.ItemRepository;
import com.example.actioneer.service.scraper.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    PriceService priceService;


    public Item addNewItem(Item item){
        item.setOriginalPrice(priceService.getCurrentPriceOfSingleItem(item));
        return itemRepository.save(item);
    }
}
