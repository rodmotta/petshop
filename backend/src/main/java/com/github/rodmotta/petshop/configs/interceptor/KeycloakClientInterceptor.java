package com.github.rodmotta.petshop.configs.interceptor;

import com.github.rodmotta.petshop.clients.keycloak.KeycloakClient;
import com.github.rodmotta.petshop.dtos.responses.TokenResponse;
import feign.RequestInterceptor;
import feign.RequestTemplate;

import java.time.LocalDateTime;

public class KeycloakClientInterceptor implements RequestInterceptor {

    private final KeycloakClient keycloakClient;
    private TokenResponse token;

    public KeycloakClientInterceptor(KeycloakClient keycloakClient) {
        this.keycloakClient = keycloakClient;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        if (token == null) {
            token = new TokenResponse(keycloakClient.getClientToken());
        }

        if (LocalDateTime.now().isBefore(token.getAccessTokenExpire())) {
            requestTemplate.header("Authorization", "Bearer " + token.getAccessToken());
        } else {
            token = new TokenResponse(keycloakClient.getClientToken());
            requestTemplate.header("Authorization", "Bearer " + token.getAccessToken());
        }
    }
}
