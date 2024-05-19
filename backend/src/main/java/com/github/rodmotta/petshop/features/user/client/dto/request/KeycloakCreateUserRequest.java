package com.github.rodmotta.petshop.features.user.client.dto.request;

import java.util.List;

public record KeycloakCreateUserRequest(
        String username,
        String email,
        String firstName,
        String lastName,
        List<KeycloakCreateUserCredentialRequest> credentials,
        Boolean enabled) {
}
