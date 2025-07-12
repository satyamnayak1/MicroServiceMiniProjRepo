package com.nt.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class IPLPlayerControlerAdvice {
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handelIAE(IllegalArgumentException iea){
		
		return new ResponseEntity<String>(iea.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handelIAE(Exception e){
		
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
