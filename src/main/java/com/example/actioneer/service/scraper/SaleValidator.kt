package com.example.actioneer.service.scraper

import com.example.actioneer.model.Item
import com.example.actioneer.repository.ItemRepository
import com.example.actioneer.service.scraper.dedicated.AliExpressScraper
import com.example.actioneer.service.scraper.dedicated.AmazonScraper
import com.example.actioneer.service.scraper.dedicated.AsosScraper
import com.example.actioneer.service.scraper.dedicated.BlueTomatoScraper
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
class SaleValidator(
        private val amazonScraper: AmazonScraper,
        private val asosScraper: AsosScraper,
        private val blueTomatoScraper: BlueTomatoScraper,
        private val aliExpressScraper: AliExpressScraper) {
    /**
     * Takes all the URLs and decides witch are on sale
     * */
    fun getOnSaleURLS(urls: List<Item>): List<Item> {
        return urls.filter {
            when (it.domain) {
                "www.amazon.com" -> amazonScraper.isOnSale(it)
                "www.asos.com" -> asosScraper.isOnSale(it)
                "www.blue-tomato.com" -> blueTomatoScraper.isOnSale(it)
                "www.aliexpress.com" -> aliExpressScraper.isOnSale(it)
                else -> false
            }
        }
    }

}