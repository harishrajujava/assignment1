package com.myshop.att.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myshop.att.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
