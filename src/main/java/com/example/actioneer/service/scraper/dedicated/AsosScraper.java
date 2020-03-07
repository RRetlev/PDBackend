package com.example.actioneer.service.scraper.dedicated;

import com.example.actioneer.service.scraper.Scraper;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;



@Component
public class AsosScraper extends Scraper {
    @Override
    public double getPrice(String url) {
        return getPriceFromFile(getHTMLToParse(url));
    }

    @Override
    public double getPriceFromFile(Document doc) {
        return Double.parseDouble((doc.getElementsByClass("current_price").text()).substring(1));
    }
}
