package com.github.rodmotta.petshop.dtos.requests;

import java.util.List;

public record UserKeycloakRequest(
        String username,
        String email,
        String firstName,
        String lastName,
        List<CredentialKeycloakRequest> credentials,
        Boolean enabled) {
}
