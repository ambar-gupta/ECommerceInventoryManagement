package com.ambar.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class InventoryControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnInventorySortedByExpiry() throws Exception {

        mockMvc.perform(
                get("/inventory/1003")
                        .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.productId").value(1003))
        .andExpect(jsonPath("$.batches").isArray())
        .andExpect(jsonPath("$.batches.length()").value(2));
    }
    
    @Test
    void shouldReserveInventory() throws Exception {

        String requestBody = """
            {
              "productId": 1005,
              "quantity": 10
            }
            """;

        mockMvc.perform(
                put("/inventory/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
        )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").isArray())
        .andExpect(jsonPath("$.length()").value(1));
    }
}

