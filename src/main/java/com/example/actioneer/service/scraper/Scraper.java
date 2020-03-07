package com.example.actioneer.service.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public abstract class Scraper {
    public abstract double getPrice(String url);
    public abstract double getPriceFromFile(Document doc);

    protected Document getHTMLToParse(String url){
        Document doc = null;
        try{
            doc = Jsoup.connect(url).get();
        }
        catch (
            IOException e
        ){
            e.printStackTrace();
        }
        return doc;
    };


}
