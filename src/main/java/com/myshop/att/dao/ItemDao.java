package com.myshop.att.dao;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.att.entities.Item;
import com.myshop.att.entities.OrderStatus;
import com.myshop.att.repositories.ItemRepository;

@Service
public class ItemDao {
	
	@Autowired
	private ItemRepository itemRepository;
	
	public Item acceptShipDate(Item requestItem, Long orderId, Long itemId) {
		Item currentItem = itemRepository.findById(itemId).orElse(null);
		if(Objects.nonNull(currentItem)) {
			if(!currentItem.isUserAcceptedDelay() && currentItem.getStatus()!= OrderStatus.CANCELLED) {
				currentItem.setNewEstimatedShipDateRange(requestItem.getNewEstimatedShipDateRange());
				currentItem.setUserAcceptedDelay(true);
			}
			return itemRepository.save(currentItem);
		}
		return null;
	}

	public Item cancelItem(Item requestItem, Long orderId, Long itemId) {
		Item currentItem = itemRepository.findById(itemId).orElse(null);
		if(Objects.nonNull(currentItem)) {
			if(currentItem.getStatus()!= OrderStatus.CANCELLED && currentItem.getStatus()!= OrderStatus.SHIPPED) {
				currentItem.setStatus(OrderStatus.CANCELLED);;
			}
			return itemRepository.save(currentItem);
		}
		return null;
	}

}
