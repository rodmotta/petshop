package com.github.rodmotta.petshop.dtos.responses;

import java.util.UUID;

public record CategoryResponse(
        UUID id,
        String name) {
}
