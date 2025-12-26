package com.ambar.InventoryService.dto;

import java.util.List;

public record InventoryResponseDto(
		Long productId, 
		String productName, 
		List<InventoryBatchDto> batches
		) {}

