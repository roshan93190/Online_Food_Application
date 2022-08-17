package com.food.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
   
	
	/*AddressAlreadyExists*/
	@ExceptionHandler(AddressAlreadyExists.class)
	public ResponseEntity<ErrorDetails> addressExistExpHandler(AddressAlreadyExists ae , WebRequest wa ){
		
		/*System.out.println("inside AdressExists method ");*/
	    ErrorDetails err = new ErrorDetails(LocalDateTime.now(),ae.getMessage(),wa.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.ALREADY_REPORTED);
		
	}
	
	/*AddressNotFoundException*/
	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<ErrorDetails> addUnavaiableExpHnadler(AddressNotFoundException anf ,WebRequest wa1){
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), anf.getMessage(), wa1.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err , HttpStatus.NOT_FOUND);
	}
	

	
	/*Login*/
	@ExceptionHandler(LoginThreadException.class)
	public ResponseEntity<ErrorDetails> LoginExpHandler(LoginThreadException lte,WebRequest wlte){
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(),lte.getMessage(), wlte.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err , HttpStatus.BAD_REQUEST);
	}
	
	/*MainException*/
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> myExpHandlerMain(Exception ie,WebRequest wr)  {
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), ie.getMessage(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);		
	}	
	
}
