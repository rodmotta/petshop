package com.github.rodmotta.petshop.dtos.requests;

public record CredentialKeycloakRequest(
        Boolean temporary,
        String type,
        String value
) {
}
