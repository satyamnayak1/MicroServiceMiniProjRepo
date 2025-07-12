package com.nt.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nt.exception.TeamNotFoundException;

@RestControllerAdvice
public class IPLTeamRestControllerAdvice {
	
	@ExceptionHandler(TeamNotFoundException.class)
	public ResponseEntity<String> handelIAE(TeamNotFoundException iae){
		
		return new ResponseEntity<String>(iae.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handelE(Exception e){
		
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
