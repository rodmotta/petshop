package com.github.rodmotta.petshop.dtos.responses;

public record TokenKeycloakResponse(
        String access_token,
        int expires_in,
        String refresh_token,
        int refresh_expires_in) {
}
