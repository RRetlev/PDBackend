package com.example.actioneer.service.scraper

import com.example.actioneer.model.Item
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
open class UrlService(private val priceService: PriceService) {

    /**
     * Takes all the URLs and decides witch are on sale
     * */
    fun getOnSaleURLS(urls: List<Item>): List<Item> {
        return urls.filter {
            priceService.getOnlinePrice(it) < it.originalPrice
        }
    }
}