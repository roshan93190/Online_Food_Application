package com.food.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.food.model.Item;
import com.food.Service.ItemService;

@RestController
@RequestMapping("/foodPanda")
public class ItemController {

	@Autowired
	private ItemService itemService;

	
	@PostMapping("/additem/{restId}/{cateId}")
	public ResponseEntity<Item> addItemToRestaurant(@RequestBody Item item, @PathVariable Integer restId, @PathVariable Integer cateId){
		Item i = itemService.addItem(item, restId, cateId);
		return new ResponseEntity<Item>(i, HttpStatus.CREATED);
	}
	
	@GetMapping("/items")
	public List<Item> getAllItems(){
		return itemService.getAllItem();
	}
}

