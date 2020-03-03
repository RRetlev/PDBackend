package com.example.actioneer.service.email

import com.example.actioneer.model.Item
import com.example.actioneer.repository.ItemRepository
import org.springframework.stereotype.Service

@Service
class EmailPlanner{

    /**
     * Orders all the valid urls to their email address
     */
    fun createEmailMap(items: List<Item>): HashMap<String, List<String>> {
        val emailPlan = HashMap<String, List<String>>()
        items.map { item ->
            {
                emailPlan.putIfAbsent(item.email, emptyList())
                emailPlan.put(item.email, emailPlan[item.email]!!.plus(item.url))

            }
        }
        return emailPlan
    }
}