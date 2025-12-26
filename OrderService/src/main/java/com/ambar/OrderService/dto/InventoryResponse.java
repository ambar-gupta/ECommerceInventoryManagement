package com.ambar.OrderService.dto;

import java.util.List;

public record InventoryResponse(Long productId, 
		String productName, 
		List<InventoryBatch> batches) {

}
