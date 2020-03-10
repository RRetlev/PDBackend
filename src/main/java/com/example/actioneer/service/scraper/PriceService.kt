package com.example.actioneer.service.scraper

import com.example.actioneer.model.Item
import com.example.actioneer.service.scraper.dedicated.AliExpressScraper
import com.example.actioneer.service.scraper.dedicated.AmazonScraper
import com.example.actioneer.service.scraper.dedicated.AsosScraper
import com.example.actioneer.service.scraper.dedicated.BlueTomatoScraper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
open class PriceService(
        private val asosScraper: AsosScraper,
        private val blueTomatoScraper: BlueTomatoScraper,
        private val aliExpressScraper: AliExpressScraper) {
    @Autowired
    private lateinit var amazonScraper: AmazonScraper

    /**
     * Takes all the URLs and decides witch are on sale
     * */

    open fun getOnlinePrice(item: Item?): Double {
        return when (item?.domain) {
            "www.amazon.com" -> amazonScraper.getPrice(item.url)
            "www.asos.com" -> asosScraper.getPrice(item.url)
            "www.blue-tomato.com" -> blueTomatoScraper.getPrice(item.url)
            "www.aliexpress.com" -> aliExpressScraper.getPrice(item.url)
            else -> Double.NEGATIVE_INFINITY
        }
    }

    fun getCurrentPriceOfSingleItem(item: Item): Double {
        return getOnlinePrice(item)
    }

}