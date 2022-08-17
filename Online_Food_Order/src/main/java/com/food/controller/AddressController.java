package com.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.Service.AddressService;
import com.food.model.Address;
import com.food.model.User;



@RestController
@RequestMapping("/foodPanda")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/address")
	public User addAddress(@RequestBody Address address) {
		return addressService.addAddress(address);
	}
}