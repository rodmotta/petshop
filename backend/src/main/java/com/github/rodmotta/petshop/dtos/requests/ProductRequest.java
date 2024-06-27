package com.github.rodmotta.petshop.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductRequest(
        @NotBlank(message = "Can not be blank.")
        String name,
        @NotNull(message = "Can not be null.")
        BigDecimal price,
        @NotNull(message = "Can not be null.")
        UUID brandId) {
}
