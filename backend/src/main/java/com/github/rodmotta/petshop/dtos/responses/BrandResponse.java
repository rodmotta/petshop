package com.github.rodmotta.petshop.dtos.responses;

import java.util.UUID;

public record BrandResponse(
        UUID id,
        String name) {
}
