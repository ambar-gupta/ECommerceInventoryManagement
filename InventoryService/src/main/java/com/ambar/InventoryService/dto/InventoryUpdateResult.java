package com.ambar.InventoryService.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class InventoryUpdateResult {
    private boolean success;
    private List<Long> reservedBatchIds;
    private String message;
}
