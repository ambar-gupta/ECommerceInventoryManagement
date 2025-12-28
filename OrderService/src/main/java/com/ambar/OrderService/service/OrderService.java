package com.ambar.OrderService.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.ambar.OrderService.client.InventoryClient;
import com.ambar.OrderService.dto.InventoryBatch;
import com.ambar.OrderService.dto.InventoryResponse;
import com.ambar.OrderService.dto.OrderRequest;
import com.ambar.OrderService.dto.OrderResponse;
import com.ambar.OrderService.entity.Order;
import com.ambar.OrderService.exception.OrderFailedException;
import com.ambar.OrderService.repo.OrderRepository;
import com.ambar.OrderService.util.OrderStatus;

@Service
public class OrderService {

	private final InventoryClient client;
    private final OrderRepository repo;
    

    public OrderService(InventoryClient client,OrderRepository repo) {
        this.client = client;
        this.repo = repo;
    }

    public OrderResponse placeOrder(OrderRequest orderRequest) {
    	
    	try {
    		InventoryResponse productDetailsInInventory = client.getInventory(orderRequest.productId());
	        
	        if (productDetailsInInventory == null || productDetailsInInventory.batches().isEmpty()) {
	            throw new RuntimeException("Product not available");
	        }
	        
	        // Check availability
	        int totalAvailable = productDetailsInInventory.batches()
	                .stream()
	                .mapToInt(InventoryBatch::quantity)
	                .sum();

	        if (totalAvailable < orderRequest.quantity()) {
	            throw new RuntimeException("Insufficient stock");
	        }
	        
	        List<Long> reservedBatchIds = client.updateInventory(orderRequest.productId(),
	        		orderRequest.quantity());
	        
	        Order order = new Order();
	        order.setProductId(orderRequest.productId());
	        order.setProductName(productDetailsInInventory.productName());
	        order.setQuantity(orderRequest.quantity());
	        order.setStatus(OrderStatus.PLACED);
	        order.setOrderDate(LocalDate.now());

	        repo.save(order);
	        
	        return new OrderResponse(
	                order.getOrderId(),
	                order.getProductId(),
	                order.getProductName(),
	                order.getQuantity(),
	                order.getStatus(),
	                reservedBatchIds,
	                "Order placed. Inventory reserved."
	        );
   
	    } catch (HttpClientErrorException ex) {

	        String inventoryError = ex.getResponseBodyAsString();

	        throw new OrderFailedException(
	                "Inventory error: " + inventoryError
	        );
	    }
    	catch (Exception ex) {
            throw new RuntimeException("Inventory update failed");
        }

    }
}

