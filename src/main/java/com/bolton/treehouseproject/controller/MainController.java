package com.bolton.treehouseproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bolton.treehouseproject.domains.Item;
import com.bolton.treehouseproject.itemfactory.ItemFactory;
import com.bolton.treehouseproject.repositories.ItemRepository;
import com.bolton.treehouseproject.services.ModelAttributeService;

@Controller
public class MainController {
	// A standard controller for mapping urls
	
	// Injects objects implicitally 
	
	@Autowired
	ItemFactory itemFactory;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	ModelAttributeService modelAttributeService;
	
	@Autowired
	HttpSession session;
	
	@GetMapping(path="/")
	public String index(Model model) {
		
		// Adds all attributes for use within templates
		
		modelAttributeService.AddAllAttributes(model);

		return "index";
	}
	
	@GetMapping(path="/about")
	public String about(Model model) {
		modelAttributeService.AddAllAttributes(model);
		
		return "about";
	}
	
	@RequestMapping(value="/search")
	public String search(@RequestParam String searchInput) {
		
		// If the search value is equal to any available item, replace all items within the session with that item
		
		for (Item item : itemRepository.findAll()) {
			if (searchInput.equals(item.getItemTitle())) {
				session.setAttribute("Items", item);
			}
		}
		
		return "redirect:/catalog";
		
	}
	
	@GetMapping(path="/catalog")
	public String catalog(Model model) {
		
		// Adds all attributes for use within templates within the current session
		
		modelAttributeService.AddAllAttributes(model);
		
		session.setAttribute("Items", itemRepository.findAll());
		
		return "catalog";
	}
	
	@GetMapping(path="contact")
	public String contact(Model model) {
		
		// Adds all attributes for use within templates within the current session
		
		modelAttributeService.AddAllAttributes(model);
		
		return "contact";
	}
	
	@RequestMapping(path="/add")
	public String addItem(@RequestParam String itemTitle, Model model) {
		
		
		modelAttributeService.AddAllAttributes(model);
		
		itemFactory.getItem(itemTitle);
		
		return "redirect:/catalog";
	}
	
	@RequestMapping(path="/checkout")
	public String checkoutItems(Model model) {		
		modelAttributeService.AddAllAttributes(model);
		
		itemFactory.checkoutItems();
		
		return "checkout";
	}
	
	@RequestMapping(path="/clearItems")
	public String clearItems(Model model) {
		modelAttributeService.AddAllAttributes(model);
		
		itemFactory.clearItems();
		
		return "redirect:/catalog";
	}
}