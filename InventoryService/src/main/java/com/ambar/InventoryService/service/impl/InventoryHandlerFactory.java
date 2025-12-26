package com.ambar.InventoryService.service.impl;

import org.springframework.stereotype.Component;

import com.ambar.InventoryService.service.InventoryHandler;

@Component
public class InventoryHandlerFactory {

    private final FreshInventoryHandler fifoHandler;
    private final ExpiryInventoryHandler expiryHandler;

    public InventoryHandlerFactory(FreshInventoryHandler fifoHandler,
                                   ExpiryInventoryHandler expiryHandler) {
        this.fifoHandler = fifoHandler;
        this.expiryHandler = expiryHandler;
    }

    public InventoryHandler getHandler(String strategy) {

        if ("FRESH".equalsIgnoreCase(strategy)) {
            return fifoHandler;
        }

        if ("EXPIRY".equalsIgnoreCase(strategy)) {
            return expiryHandler;
        }

        throw new IllegalArgumentException("Invalid inventory strategy: " + strategy);
    }
}


