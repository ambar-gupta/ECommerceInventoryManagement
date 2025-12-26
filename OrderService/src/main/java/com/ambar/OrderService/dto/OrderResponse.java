package com.ambar.OrderService.dto;

import java.util.List;

import com.ambar.OrderService.util.OrderStatus;

public record OrderResponse(
        Long orderId,
        Long productId,
        String productName,
        Integer quantity,
        OrderStatus status,
        List<Long> reservedFromBatchIds,
        String message
) {}
