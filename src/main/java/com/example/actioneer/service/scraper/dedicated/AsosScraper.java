package com.example.actioneer.service.scraper.dedicated;

import com.example.actioneer.service.scraper.Scraper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AsosScraper extends Scraper {
    @Override
    public double getPrice(String url) {
        double price = 0;
        try {
            Document doc = Jsoup.connect(url)
                    .get();
            price =  Double.parseDouble( (doc.getElementsByClass("current_price").text()).substring(1));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return price;
    }
}
