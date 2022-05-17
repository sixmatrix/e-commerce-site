package com.bolton.treehouseproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

import com.bolton.treehouseproject.domains.Item;
import com.bolton.treehouseproject.repositories.ItemRepository;

@Service
public class ItemAvailabilityService {
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	HttpSession session;
	
	public void checkItemQuantityBelowZero() {
		
		for (Item item : itemRepository.findAll()) {
			if (item.getItemQuantity() <= 0) {
				itemRepository.delete(item);
			}
		}
	}
}
