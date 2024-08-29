package com.github.rodmotta.petshop.v2.core.product.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Product {
    private UUID id;
    private final UUID code;
    private int version;
    private boolean active;
    private LocalDateTime createdAt;
    private String name;
    private BigDecimal price;

    public Product(UUID id, UUID code, int version, boolean active, LocalDateTime createdAt, String name, BigDecimal price) {
        this.id = id;
        this.code = code;
        this.version = version;
        this.active = active;
        this.createdAt = createdAt;
        this.name = name;
        this.price = price;
    }

    public Product(String name, BigDecimal price) {
        this.code = UUID.randomUUID();
        this.version = 1;
        this.active = true;
        this.createdAt = LocalDateTime.now();
        this.name = name;
        this.price = price;
    }

    public Product newVersion(String name, BigDecimal price) {
        return new Product(null, code, version++, true, LocalDateTime.now(), name, price);
    }

    public void disable() {
        this.active = false;
    }

    public UUID getId() {
        return id;
    }

    public UUID getCode() {
        return code;
    }

    public int getVersion() {
        return version;
    }

    public boolean isActive() {
        return active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
