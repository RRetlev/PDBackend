package com.example.actioneer.service.scraper.dedicated;

import com.example.actioneer.service.scraper.Scraper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
public class AmazonScraper extends Scraper {

    public double getPrice(String url) {
        double price = 0;
        try {
            Document doc = Jsoup.connect(url)
                    .get();

            price =  Double.parseDouble( doc.getElementById("priceblock_ourprice").text());

        } catch (IOException e) {
            e.printStackTrace();
        }
        //TODO
        return price;

    }

}
