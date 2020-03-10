package com.example.actioneer.service.email

import com.example.actioneer.model.Item
import org.springframework.stereotype.Service

@Service
class EmailPlanner{

    /**
     * Orders all the valid urls to their email address
     */
    fun createEmailMap(items: List<Item>): Map<String, List<String>> {
        return items.groupBy { it.email }.mapValues { it.value.map { it.url } }
    }
}