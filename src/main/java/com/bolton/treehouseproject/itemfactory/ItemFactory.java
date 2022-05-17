package com.bolton.treehouseproject.itemfactory;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolton.treehouseproject.domains.Item;
import com.bolton.treehouseproject.repositories.ItemRepository;
import com.bolton.treehouseproject.services.DiscountService;
import com.bolton.treehouseproject.services.ItemAvailabilityService;

@Service
@Transactional
public class ItemFactory {
	
	private Set<Item> shoppingCart = new HashSet<Item>();
	
	private double Total = 0.0;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	DiscountService discountService;
	
	@Autowired
	ItemAvailabilityService itemAvailabilityService;
	
	@Autowired
	HttpSession session;
	
	@Transactional
	public void getItem(String itemTitle) {
		
		// Add chosen item to shopping cart
		
		for (Item item : itemRepository.findAll()) {
			if (itemTitle.equalsIgnoreCase(item.itemTitle)){
				shoppingCart.add(item);
				Total += item.getItemPrice();
			}
			
			
		}
		
		// Verify whether discount may be applied
		
		Total = discountService.verifyDiscount(Total);
		
		session.setAttribute("shoppingCart", shoppingCart);
		session.setAttribute("Total", Total);
		
	}

	@Transactional
	public void checkoutItems() {
		// TODO Auto-generated method stub
		
		// For each item bought, remove from database
		
		for (Item item : shoppingCart) {
			item.setItemQuantity(item.getItemQuantity() - 1);
			itemRepository.save(item);
		}
		
		clearItems();
	}
	
	public void clearItems() {
		shoppingCart.clear();
		Total = 0;
		session.setAttribute("shoppingCart", shoppingCart);
		session.setAttribute("Total", Total);
		
		itemAvailabilityService.checkItemQuantityBelowZero();
	}
}

