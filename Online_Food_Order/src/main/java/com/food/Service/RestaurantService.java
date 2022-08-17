package com.food.Service;

import java.util.List;

import com.food.model.Address;
import com.food.model.Item;
import com.food.model.Restaurant;

public interface RestaurantService {

	public Restaurant addRestaurant(Restaurant restaurant, Integer ownerId);
	
	public List<Restaurant> getAllRestaurants();
	
	public Restaurant addAddress(Address address, Integer restId);
	
	
	public Restaurant AddItems(Item item, Integer restId);
}
