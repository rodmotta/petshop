package com.github.rodmotta.petshop.commons.clients.keycloak.representation.request;

public record CredentialRequest(
        Boolean temporary,
        String type,
        String value
) {
}
