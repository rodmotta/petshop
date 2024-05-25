package com.github.rodmotta.petshop.features.product.representation.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRequest(
        @NotBlank(message = "Can not be blank.")
        String name,
        @NotNull(message = "Can not be null.")
        BigDecimal price) {
}
