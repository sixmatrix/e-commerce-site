package com.bolton.treehouseproject.services;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bolton.treehouseproject.repositories.ItemRepository;

@Service
public class ModelAttributeService {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	ItemRepository itemRepository;

	public void AddAllAttributes(Model model) {
		boolean isAuthorised = session.getAttribute("userName") != null;
		model.addAttribute("isAuthorised", isAuthorised);
		model.addAttribute("Items", session.getAttribute("Items"));
		model.addAttribute("userName", session.getAttribute("userName"));
		model.addAttribute("shoppingCart", session.getAttribute("shoppingCart"));
		model.addAttribute("itemCount", session.getAttribute("itemCount"));
		model.addAttribute("Total", session.getAttribute("Total"));
	}
}
