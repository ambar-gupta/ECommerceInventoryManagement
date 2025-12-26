package com.ambar.OrderService.dto;

public record InventoryUpdateRequest(Long productId,
        Integer quantity) {

}
