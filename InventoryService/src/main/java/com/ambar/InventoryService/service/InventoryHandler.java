package com.ambar.InventoryService.service;

import java.util.List;

import com.ambar.InventoryService.dto.InventoryResponseDto;

public interface InventoryHandler {
		
	InventoryResponseDto getBatches(Long productId);
	
    List<Long> reserveStock(Long productId, int quantity);

}


