package com.ambar.InventoryService.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ambar.InventoryService.dto.InventoryResponseDto;
import com.ambar.InventoryService.dto.OrderRequest;
import com.ambar.InventoryService.entity.InventoryBatch;
import com.ambar.InventoryService.service.impl.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<InventoryResponseDto> getInventory(@PathVariable Long productId,
            @RequestParam(defaultValue = "EXPIRY") String strategy) {

        InventoryResponseDto response = inventoryService.getInventory(productId, strategy);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity<List<Long>> updateInventory(@RequestParam(defaultValue = "EXPIRY") String strategy,
            @RequestBody OrderRequest orderRequest) {

        List<Long> batchesReversed = inventoryService.updateInventory(orderRequest, strategy);
        return ResponseEntity.ok(batchesReversed);
    }
}




