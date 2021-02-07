package com.myshop.att.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.att.dao.ItemDao;
import com.myshop.att.dao.OrderDao;
import com.myshop.att.entities.Item;
import com.myshop.att.entities.Order;

@RestController
@RequestMapping("/api/v1/orderactions")
public class OrderActionsController {

	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@PostMapping(value = "/acceptShipDate")
    public ResponseEntity<Item> acceptShipDate(@RequestBody Item requestItem, @RequestParam("orderId") Long orderId, @RequestParam("itemId") Long itemId) {
		if(Objects.isNull(requestItem) || Objects.isNull(itemId) || Objects.isNull(orderId)) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		Item responseItem = itemDao.acceptShipDate(requestItem, orderId, itemId);
		if(Objects.isNull(responseItem)) {
			return new ResponseEntity<>(requestItem, HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(responseItem, HttpStatus.OK);
    }
	
	@PostMapping(value = "/cancelItem")
    public ResponseEntity<Item> cancelItem(@RequestBody Item requestItem, @RequestParam("orderId") Long orderId, @RequestParam("itemId") Long itemId) {
		if(Objects.isNull(requestItem) || Objects.isNull(itemId) || Objects.isNull(orderId)) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		Item responseItem = itemDao.cancelItem(requestItem, orderId, itemId);
		if(Objects.isNull(responseItem)) {
			return new ResponseEntity<>(requestItem, HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(responseItem, HttpStatus.OK);
    }
	
	@PostMapping(value = "/cancelOrder")
    public ResponseEntity<Order> cancelOrder(@RequestBody Order requestOrder, @RequestParam("orderId") Long orderId) {
		if(Objects.isNull(requestOrder) || Objects.isNull(orderId)) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		Order responseOrder = orderDao.cancelOrder(requestOrder, orderId);
		if(Objects.isNull(responseOrder)) {
			return new ResponseEntity<>(requestOrder, HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(responseOrder, HttpStatus.OK);
    }
}
