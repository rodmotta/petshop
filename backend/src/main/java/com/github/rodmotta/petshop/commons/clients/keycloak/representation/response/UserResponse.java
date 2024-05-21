package com.github.rodmotta.petshop.commons.clients.keycloak.representation.response;

public record UserResponse(String id, String username, String email, String firstName, String lastName,
                           Boolean emailVerified, Long createdTimestamp, Boolean enabled) {
}
