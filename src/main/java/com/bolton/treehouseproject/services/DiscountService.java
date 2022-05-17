package com.bolton.treehouseproject.services;

import org.springframework.stereotype.Service;

@Service
public class DiscountService {
	
	public double verifyDiscount(double Total) {
		if (Total >= 50.0) {
			Total = Total / 100 * 10;
		}
		return Total;
	}

}
