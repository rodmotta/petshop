package com.github.rodmotta.petshop.clients.keycloak.dtos.request;

public record CredentialRequest(
        Boolean temporary,
        String type,
        String value
) {
}
