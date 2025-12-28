package com.ambar.OrderService.exception;

public class OrderFailedException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public OrderFailedException(String message) {
		super(message);
	}
	
	

}
