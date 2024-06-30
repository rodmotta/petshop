package com.github.rodmotta.petshop.dtos.responses;

import java.util.UUID;

public record UserKeycloakResponse(
        UUID id,
        String username,
        String email,
        String firstName,
        String lastName,
        Boolean emailVerified,
        Long createdTimestamp,
        Boolean enabled) {
}
