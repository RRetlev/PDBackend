package com.example.actioneer.service.scraper.dedicated;

import com.example.actioneer.service.scraper.Scraper;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;


@Component
public class BlueTomatoScraper extends Scraper {
    @Override
    public double getPrice(String url) {
        return getPriceFromFile(getHTMLToParse(url));
    }
    @Override
    public double getPriceFromFile(Document doc) {
        return Double.parseDouble((doc.getElementsByClass("c-details-box__price-current").text()).substring(2));
    }
}
