package com.ambar.InventoryService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class InventoryUpdateRequest {
    private Long productId;
    private Integer quantity; 
    private Long orderId;
}
