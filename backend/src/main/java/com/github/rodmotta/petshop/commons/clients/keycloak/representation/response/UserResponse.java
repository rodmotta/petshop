package com.github.rodmotta.petshop.commons.clients.keycloak.representation.response;

import java.util.UUID;

public record UserResponse(UUID id, String username, String email, String firstName, String lastName,
                           Boolean emailVerified, Long createdTimestamp, Boolean enabled) {
}
