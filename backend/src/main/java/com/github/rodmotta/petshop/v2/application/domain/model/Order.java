package com.github.rodmotta.petshop.v2.application.domain.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Order {

    private UUID orderId;
    private UUID customerId;
    private List<OrderItem> orderItems;
    private String status; //fixme - usar enum
    private LocalDateTime orderDate;

    public Order(UUID orderId, UUID customerId, List<OrderItem> orderItems, String status, LocalDateTime orderDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderItems = orderItems;
        this.status = status;
        this.orderDate = LocalDateTime.now();
    }
}
