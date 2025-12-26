package com.ambar.OrderService.dto;

public record OrderRequest(
        Long productId,
        Integer quantity
) {

    public OrderRequest {
        if (productId == null) {
            throw new IllegalArgumentException("productId must not be null");
        }
        if (quantity == null || quantity <= 0) {
            throw new IllegalArgumentException("quantity must be greater than zero");
        }
    }
}
