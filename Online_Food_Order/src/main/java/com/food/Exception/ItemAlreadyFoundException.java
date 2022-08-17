package com.food.Exception;

import lombok.NoArgsConstructor;

//if items is allready present
@NoArgsConstructor
public class ItemAlreadyFoundException extends RuntimeException{
public ItemAlreadyFoundException(String message) {
	   super(message);
}
}
