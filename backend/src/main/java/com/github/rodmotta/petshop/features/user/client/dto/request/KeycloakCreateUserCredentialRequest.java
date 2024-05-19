package com.github.rodmotta.petshop.features.user.client.dto.request;

public record KeycloakCreateUserCredentialRequest(
        Boolean temporary,
        String type,
        String value) {
}
