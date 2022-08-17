package com.food.Service;

import com.food.model.FoodCart;
import com.food.model.UserType;

public interface FoodCartService {
	
	public FoodCart addToCart(int id,int quty,UserType userType);
	
	public String removeFromCart(Integer itemId);

}