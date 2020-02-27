package com.example.actioneer.service;

import com.example.actioneer.model.Item;
import com.example.actioneer.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemService {

    @Autowired
    ItemRepository itemRepository;


    public Item addNewItem(Item item){
        return itemRepository.save(item);
    }
}
