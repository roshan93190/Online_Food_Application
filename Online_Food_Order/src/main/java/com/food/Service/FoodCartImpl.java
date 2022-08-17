package com.food.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.model.FoodCart;
import com.food.Repository.FoodCartRepo;

@Service
public class FoodCartImpl implements FoodCartService{
	
	@Autowired
	private FoodCartRepo foodCartRepo;

	@Override
	public FoodCart addToCart() {
		
		return null;
	}

	@Override
	public String removeFromCart(Integer itemId) {
		// TODO Auto-generated method stub
		return null;
	}

}