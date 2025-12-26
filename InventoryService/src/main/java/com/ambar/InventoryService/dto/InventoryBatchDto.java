package com.ambar.InventoryService.dto;

import java.time.LocalDate;

public record InventoryBatchDto(Long batchId, Integer quantity, LocalDate expiryDate) {}
