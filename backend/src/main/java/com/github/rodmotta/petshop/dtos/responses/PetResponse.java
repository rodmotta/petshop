package com.github.rodmotta.petshop.dtos.responses;

import java.util.UUID;

public record PetResponse(
        UUID id,
        String name) {
}
