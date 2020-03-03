package com.example.actioneer.service.scraper

import com.example.actioneer.model.Item
import com.example.actioneer.service.scraper.dedicated.AliExpressScraper
import com.example.actioneer.service.scraper.dedicated.AmazonScraper
import com.example.actioneer.service.scraper.dedicated.AsosScraper
import com.example.actioneer.service.scraper.dedicated.BlueTomatoScraper
import org.springframework.stereotype.Service

@Service
class PriceService(
        private val amazonScraper: AmazonScraper,
        private val asosScraper: AsosScraper,
        private val blueTomatoScraper: BlueTomatoScraper,
        private val aliExpressScraper: AliExpressScraper) {
    /**
     * Takes all the URLs and decides witch are on sale
     * */
    fun getOnSaleURLS(urls: List<Item>): List<Item> {
        return urls.filter {
            getOnlinePrice(it) < it.originalPrice
        }
    }

    private fun getOnlinePrice(it: Item): Double {
        return when (it.domain) {
            "www.amazon.com" -> amazonScraper.getPrice(it.url)
            "www.asos.com" -> asosScraper.getPrice(it.url)
            "www.blue-tomato.com" -> blueTomatoScraper.getPrice(it.url)
            "www.aliexpress.com" -> aliExpressScraper.getPrice(it.url)
            else -> Double.POSITIVE_INFINITY
        }
    }

    fun getCurrentPriceOfSingleItem(item: Item) : Double{
            return getOnlinePrice(item)
    }

}