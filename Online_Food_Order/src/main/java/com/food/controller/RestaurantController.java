package com.food.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.model.Address;
import com.food.model.Item;
import com.food.model.Restaurant;
import com.food.Service.RestaurantService;


@RestController
@RequestMapping("/foodPanda")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping("/restaurant/{ownerId}")
	public ResponseEntity<Restaurant> saveRestaurant(@RequestBody Restaurant restaurant, @PathVariable Integer ownerId) {
		Restaurant savedRestaurant = restaurantService.addRestaurant(restaurant, ownerId);
		return new ResponseEntity<Restaurant>(savedRestaurant,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/restaurant")
	public List<Restaurant> getAllRestaurant() {
		return restaurantService.getAllRestaurants();
	}
	
	@PostMapping("/restaurant/address/{restId}")
	public ResponseEntity<Restaurant> saveAddress(@RequestBody @Valid Address address, @PathVariable Integer restId){
		Restaurant restaurant = restaurantService.addAddress(address, restId);
		return new ResponseEntity<Restaurant>(restaurant, HttpStatus.CREATED);
	}
	
	
	@PostMapping("/restaurant/item/{restId}")
	public ResponseEntity<Restaurant> saveItems(@RequestBody @Valid Item item, @PathVariable Integer restId){
		
		Restaurant restaurant =	restaurantService.AddItems(item, restId);
		return new ResponseEntity<Restaurant>(restaurant, HttpStatus.CREATED);
	}
	
}

