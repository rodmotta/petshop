package com.github.rodmotta.petshop.clients.keycloak.dtos.response;

public record KeycloakToken(String access_token,
                            int expires_in,
                            String refresh_token,
                            int refresh_expires_in) {
}
