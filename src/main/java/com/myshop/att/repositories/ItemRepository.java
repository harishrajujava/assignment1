package com.myshop.att.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myshop.att.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
