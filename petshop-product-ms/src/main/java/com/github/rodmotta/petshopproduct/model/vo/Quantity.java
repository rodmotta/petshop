package com.github.rodmotta.petshopproduct.model.vo;

public record Quantity(int value) {
    public Quantity {
        if (value <= 0) {
            throw new RuntimeException();
        }
    }
}
