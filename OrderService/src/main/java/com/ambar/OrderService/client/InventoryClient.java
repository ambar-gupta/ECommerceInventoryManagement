package com.ambar.OrderService.client;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ambar.OrderService.dto.InventoryResponse;
import com.ambar.OrderService.dto.InventoryUpdateRequest;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InventoryClient {

    private static final String INVENTORY_BASE_URL =
            "http://localhost:8081/inventory";

    private final RestTemplate restTemplate;

    public InventoryResponse getInventory(Long productId) {

        String url = INVENTORY_BASE_URL + "/" + productId;

        ResponseEntity<InventoryResponse> response =
                restTemplate.getForEntity(url, InventoryResponse.class);

        return response.getBody();
    }

    public List<Long> updateInventory(Long productId, int quantity) {

        String url = INVENTORY_BASE_URL + "/update";

        InventoryUpdateRequest request =
                new InventoryUpdateRequest(productId, quantity);

        ResponseEntity<List<Long>> response =
                restTemplate.exchange(
                        url,
                        HttpMethod.PUT,
                        new HttpEntity<>(request),
                        new ParameterizedTypeReference<List<Long>>() {}
                );

        return response.getBody();
    }
}
