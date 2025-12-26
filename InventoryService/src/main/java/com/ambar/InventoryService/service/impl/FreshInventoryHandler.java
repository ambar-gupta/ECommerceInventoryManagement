package com.ambar.InventoryService.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ambar.InventoryService.dto.InventoryBatchDto;
import com.ambar.InventoryService.dto.InventoryResponseDto;
import com.ambar.InventoryService.dto.OrderRequest;
import com.ambar.InventoryService.entity.InventoryBatch;
import com.ambar.InventoryService.repository.InventoryBatchRepository;
import com.ambar.InventoryService.service.InventoryHandler;

@Service
public class FreshInventoryHandler implements InventoryHandler {

    private final InventoryBatchRepository batchRepository;

    public FreshInventoryHandler(InventoryBatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    @Override
    public InventoryResponseDto getBatches(Long productId) {
    	
        List<InventoryBatch> allBatchForProduct = batchRepository.findByProductIdOrderByCreatedDateDesc(productId);
        
        List<InventoryBatchDto> productWithAllBatchResponse = new ArrayList<>();
        for(InventoryBatch batch : allBatchForProduct ) {
        	InventoryBatchDto batchdto = new InventoryBatchDto(batch.getBatchId(), batch.getQuantity(), batch.getExpiryDate());
        	productWithAllBatchResponse.add(batchdto);
        }
        
    	InventoryResponseDto productDetails = new InventoryResponseDto(allBatchForProduct.get(0).getProductId(), 
    			allBatchForProduct.get(0).getProductName(), productWithAllBatchResponse);
    	
    	return productDetails;

    }

	@Override
	public List<Long> reserveStock(Long productId, int quantity) {
		// TODO Auto-generated method stub
		return null;
	}
}

