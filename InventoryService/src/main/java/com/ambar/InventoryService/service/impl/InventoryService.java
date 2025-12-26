package com.ambar.InventoryService.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ambar.InventoryService.dto.InventoryResponseDto;
import com.ambar.InventoryService.dto.OrderRequest;
import com.ambar.InventoryService.service.InventoryHandler;

@Service
public class InventoryService {

    private final InventoryHandlerFactory handlerFactory;

    public InventoryService(InventoryHandlerFactory handlerFactory) {
        this.handlerFactory = handlerFactory;
    }

    public InventoryResponseDto getInventory(Long productId, String strategy) {

        InventoryHandler handler = handlerFactory.getHandler(strategy);
        return handler.getBatches(productId);
    }

    public List<Long> updateInventory(OrderRequest orderRequest, String strategy) {
    	
        InventoryHandler handler = handlerFactory.getHandler(strategy);
        List<Long> batches = handler.reserveStock(orderRequest.getProductId(),orderRequest.getQuantity());
        return batches;
        
    }
}



