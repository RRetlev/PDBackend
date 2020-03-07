package com.example.actioneer;


import com.example.actioneer.service.scraper.dedicated.AliExpressScraper;
import com.example.actioneer.service.scraper.dedicated.AmazonScraper;
import com.example.actioneer.service.scraper.dedicated.AsosScraper;
import com.example.actioneer.service.scraper.dedicated.BlueTomatoScraper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ScraperTests {

    @Autowired
    AmazonScraper amazonScraper;
    @Autowired
    AsosScraper asosScraper;
    @Autowired
    BlueTomatoScraper blueTomatoScraper;
    @Autowired
    AliExpressScraper aliExpressScraper;

    private Document HTMLfile = Jsoup.parse(new File("/home/user/Documents/actioneer_backend/src/main/resources/static/ScraperTest.html"),null);

    public ScraperTests() throws IOException {
    }

    @Test
    public void TestAmazonScraper(){
        assertEquals(amazonScraper.getPriceFromFile(HTMLfile),4.0,0);
    }

    @Test
    public void TestAsosScraper(){
        assertEquals(asosScraper.getPriceFromFile(HTMLfile),5.2,0);
    }
    @Test
    public void TestBlueTomatoScraper(){
        assertEquals(blueTomatoScraper.getPriceFromFile(HTMLfile),6.8,0);
    }
    @Test
    public void TestAliExpressScraper(){
        assertEquals(aliExpressScraper.getPriceFromFile(HTMLfile),7.2,0);
    }

}
