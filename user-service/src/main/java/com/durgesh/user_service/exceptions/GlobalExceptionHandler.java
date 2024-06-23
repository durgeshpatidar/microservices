package com.durgesh.user_service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.durgesh.user_service.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException exception){
		ApiResponse response = ApiResponse.builder().message(exception.getMessage()).success(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
	}
}
