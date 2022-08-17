package com.food.Exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

//error details
public class ErrorDetails {
    
	 private LocalDateTime time;
     private String message;
     private String details;
	
}
