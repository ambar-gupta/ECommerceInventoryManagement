package com.ambar.InventoryService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ambar.InventoryService.entity.InventoryBatch;

public interface InventoryBatchRepository extends JpaRepository<InventoryBatch, Long> {

	List<InventoryBatch> findByProductIdOrderByExpiryDateAsc(Long productId);
	
	List<InventoryBatch> findByProductIdOrderByCreatedDateDesc(Long productId);
}


