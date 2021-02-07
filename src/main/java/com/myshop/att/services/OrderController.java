package com.myshop.att.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.att.dao.OrderDao;
import com.myshop.att.entities.Order;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

	@Autowired
	private OrderDao orderDao;
	
	@GetMapping(value = "order/{orderId}")
    public ResponseEntity<Order> findOrderById(@PathVariable("orderId") Long orderId) {
		Order order = orderDao.findOrder(orderId);
		if(Objects.isNull(order)) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
