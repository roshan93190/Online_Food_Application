package com.food.Service;

import com.food.model.FoodCart;

public interface FoodCartService {
	
	public FoodCart addToCart();
	
	public String removeFromCart(Integer itemId);

}