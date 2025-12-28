package com.ambar.InventoryService.exception.handler;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ambar.InventoryService.exception.InventoryNotFound;

@RestControllerAdvice
public class InventoryExceptionHandler {
	
	@ExceptionHandler(InventoryNotFound.class)
	public ResponseEntity<Map<String, String>> handleInventoryNotFound(InventoryNotFound ex) {
		
		return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of(
                        "status", "FAILED",
                        "message", ex.getMessage()
                ));
		
	}

}
