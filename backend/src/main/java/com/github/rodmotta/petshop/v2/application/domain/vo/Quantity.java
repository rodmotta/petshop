package com.github.rodmotta.petshop.v2.application.domain.vo;

public record Quantity(int quantity) {
    public Quantity {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
    }
}
