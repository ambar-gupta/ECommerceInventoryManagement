package com.ambar.OrderService.exception.handler;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ambar.OrderService.exception.OrderFailedException;

@RestControllerAdvice
public class OrderServiceExceptionHandler {
	
	@ExceptionHandler(OrderFailedException.class)
	public ResponseEntity<Map<String, String>> handleInventoryNotFound(OrderFailedException ex) {
		
		return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of(
                        "status", "ORDER FAILED",
                        "message", ex.getMessage()
                ));
		
	}

}
