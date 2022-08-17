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

import com.food.model.Customer;
import com.food.model.FoodCart;
import com.food.model.UserType;
import com.food.Service.CustomerService;
import com.food.Service.FoodCartService;

@RestController
@RequestMapping("/foodPanda")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private FoodCartService foodCartService;
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> addCustomer(@RequestBody @Valid Customer customer){
		Customer newCustomer = customerService.addCustomer(customer, UserType.CUSTOMER);
		return new ResponseEntity<Customer>(newCustomer,HttpStatus.CREATED);
	}
	
	@GetMapping("/customer")
	public List<Customer> getAllCustomer(){
		return customerService.getAllCustomer();
	}
	
	@PostMapping("/customer/addtocart/{itemId}/{itemQty}")
	public ResponseEntity<FoodCart> addToCart(@PathVariable Integer itemId, @PathVariable Integer itemQty){
			FoodCart fc = foodCartService.addToCart(itemId, itemQty, UserType.CUSTOMER);
		return new ResponseEntity<FoodCart>(fc,HttpStatus.OK);
	}
	
	@GetMapping("/customer/cart")
	public ResponseEntity<FoodCart> cartStatus(){
		return new ResponseEntity<FoodCart>(foodCartService.cartItems(), HttpStatus.OK);
	}
	
	@PostMapping("/customer/removeItem/{itemId}")
	public ResponseEntity<String> removeItem(@PathVariable Integer itemId){
		return new ResponseEntity<String>(foodCartService.removeFromCart(itemId), HttpStatus.OK);
	}
}

