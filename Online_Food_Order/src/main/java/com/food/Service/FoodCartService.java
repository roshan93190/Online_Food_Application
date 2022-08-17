package com.food.Service;

import com.food.model.FoodCart;
import com.food.model.UserType;

public interface FoodCartService {
	
	public FoodCart addToCart(Integer itemId, Integer itemQty, UserType userType);
	
	public String removeFromCart(Integer itemId);
	
	public FoodCart cartItems();

}
