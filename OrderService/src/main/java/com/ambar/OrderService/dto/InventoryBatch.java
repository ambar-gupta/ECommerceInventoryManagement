package com.ambar.OrderService.dto;

import java.time.LocalDate;

public record InventoryBatch(Long batchId, Integer quantity, LocalDate expiryDate) {

}
