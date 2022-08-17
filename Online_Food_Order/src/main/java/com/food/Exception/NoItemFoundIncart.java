package com.food.Exception;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoItemFoundIncart extends RuntimeException {
       public NoItemFoundIncart(String message) {
    	   super(message);
       }
}
