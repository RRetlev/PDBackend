package com.example.actioneer.repository;

import com.example.actioneer.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Long> {
        @Query(value = "SELECT DISTINCT URL, ID, DOMAIN FROM ITEM",
        nativeQuery = true)
        List<Item> findDistinctByURL();
}
