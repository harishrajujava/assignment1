package com.myshop.att.dao;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.att.entities.Item;
import com.myshop.att.entities.Order;
import com.myshop.att.entities.OrderStatus;
import com.myshop.att.repositories.OrderRepository;

@Service
public class OrderDao {
	
	@Autowired
	private OrderRepository orderRepository;

	public Order cancelOrder(Order requestOrder, Long orderId) {
		Order currentOrder = orderRepository.findById(orderId).orElse(null);
		if(Objects.nonNull(currentOrder) && Objects.nonNull(currentOrder.getItems())) {
			boolean canBeCanceled = true;
			List<Item> items = currentOrder.getItems();
			for(Item item : items) {
				if(item.getStatus() == OrderStatus.CANCELLED && item.getStatus() == OrderStatus.SHIPPED) {
					canBeCanceled = false;
				}
			}
			if(canBeCanceled) {
				for(Item item : items) {
					item.setStatus(OrderStatus.CANCELLED);
				}
				currentOrder.setItems(items);
			}
			return orderRepository.save(currentOrder);
		}
		return null;
	}

	public Order findOrder(Long orderId) {
		return orderRepository.findById(orderId).orElse(null);
	}
}
