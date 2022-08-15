package com.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niraj.model.Address;
import com.niraj.model.User;
import com.niraj.service.AddressService;
import com.niraj.model.Customer;

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