package com.food.Exception;


import lombok.NoArgsConstructor;

// NoitemfoundIncart
@NoArgsConstructor
public class LoginThreadException extends RuntimeException{
	public LoginThreadException(String message) {
         super(message);
	}
}
