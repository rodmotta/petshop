package com.github.rodmotta.petshop.dto.requests;

public record KeycloakCreateUserCredentialRequest(
        Boolean temporary,
        String type,
        String value) {
}
