package com.bolton.treehouseproject.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "items")
@Transactional
public class Item implements Serializable {
	
	private static final long serialVersionUID = -1505064096771705087L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "item_id")
	private int itemId;
	
	@JoinColumn(name = "item_title")
	public String itemTitle;
	
	@JoinColumn(name = "item_price")
	private double itemPrice;
	
	@JoinColumn(name = "item_image")
	private String itemImage;
	
	@JoinColumn(name = "item_description")
	private String itemDescription;
	
	@JoinColumn(name = "item_quantity")
	private int itemQuantity;
	
	public Item() {
		
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemTitle() {
		return itemTitle;
	}

	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemTitle=" + itemTitle + ", itemPrice=" + itemPrice + ", itemImage="
				+ itemImage + ", itemDescription=" + itemDescription + ", itemQuantity=" + itemQuantity + "]";
	}
	
}
