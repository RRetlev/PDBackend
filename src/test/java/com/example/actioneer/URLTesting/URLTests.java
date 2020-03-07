package com.example.actioneer.URLTesting;


import com.example.actioneer.ActioneerApplication;
import com.example.actioneer.model.Item;
import com.example.actioneer.service.scraper.PriceService;
import com.example.actioneer.service.scraper.UrlService;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ActioneerApplication.class, properties = "spring.main.allow-bean-definition-overriding=true")
public class URLTests {

    @Autowired
    UrlService urlService;

    @Autowired
    PriceService priceService;

    private static List<Item> itemList = new ArrayList<>();

    @BeforeAll
    static void init(){
        Item item = Item.builder()
                .email("rretlev@gmail.com")
                .URL("one")
                .domain("number")
                .build();
        Item item2 = Item.builder()
                .email("rretlev@gmail.com")
                .URL("two")
                .domain("number")
                .build();
        Item item3 = Item.builder()
                .email("rretlev@gmail.com")
                .URL("three")
                .domain("number")
                .build();
        Item item4 = Item.builder()
                .email("rretlev@gmail.com")
                .URL("four")
                .domain("number")
                .build();
        itemList.addAll(Arrays.asList(item,item2,item3,item4));
    }

    @Test
    public void testUrlValidation(){
        when(priceService.getOnlinePrice(any())).thenReturn(5.0);
        assertThat( urlService.getOnSaleURLS(itemList), IsEmptyCollection.empty());
    }
}
