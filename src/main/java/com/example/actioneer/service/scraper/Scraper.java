package com.example.actioneer.service.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public abstract class Scraper {
    public abstract double getPrice(String url);

    public abstract double getPriceFromFile(Document doc);

    protected Document getHTMLToParse(String url) {

        System.setProperty("webdriver.gecko.driver", "/home/user/Documents/Gecko/geckodriver-v0.26.0-linux64/geckodriver");


        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setHeadless(true);


        WebDriver driver = new FirefoxDriver(firefoxOptions);
        driver.get(url);
        Document doc = Jsoup.parse(driver.getPageSource());
        driver.quit();
        return doc;
    }

    ;


}
