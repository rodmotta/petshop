package com.github.rodmotta.petshop.features.product.representation.responses;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponse(
        UUID id,
        String name,
        BigDecimal price) {
}
