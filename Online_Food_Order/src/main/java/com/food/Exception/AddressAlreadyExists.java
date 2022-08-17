package com.food.Exception;


import lombok.NoArgsConstructor;

// if address is already exists
 
@NoArgsConstructor
public class AddressAlreadyExists extends RuntimeException {
     
	public AddressAlreadyExists(String message) {
		super(message);
	}
	
	
}