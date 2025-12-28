package com.ambar.InventoryService.exception;

public class InventoryNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InventoryNotFound(String message) {
		super(message);
	}

}
