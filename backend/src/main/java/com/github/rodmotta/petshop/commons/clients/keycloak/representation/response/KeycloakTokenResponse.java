package com.github.rodmotta.petshop.commons.clients.keycloak.representation.response;

public record KeycloakTokenResponse(String access_token,
                                    Integer expires_in,
                                    String refresh_token,
                                    Integer refresh_expires_in) {
}
