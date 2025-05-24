package com.hexaware.AdminMicrocontroller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
	
	public ResponseEntity<String> UserNotFoundExceptionHandler(UserNotFoundException exception)
	{
		return new ResponseEntity<String>("User not found, enter correct data",HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<String> EmptyTableExceptionHandler(EmptyTableException exception)
	{
		return new ResponseEntity<String>("Empty table found, insert data",HttpStatus.NO_CONTENT);
	}

}
