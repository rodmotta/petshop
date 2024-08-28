package com.github.rodmotta.petshop.v2.core.order.domain.model;

import java.util.UUID;

public class OrderItem {

    private UUID id;
    private UUID customerId;
    private UUID productId;
    private int quantity;

    public OrderItem(UUID id, UUID customerId, UUID productId, int quantity) {
        this.id = id;
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public OrderItem(UUID productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public UUID getId() {
        return id;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public UUID getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) throw new IllegalArgumentException("Stock must be greater than zero");
        this.quantity = quantity;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }
}
