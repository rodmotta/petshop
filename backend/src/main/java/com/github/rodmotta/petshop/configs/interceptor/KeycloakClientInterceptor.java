package com.github.rodmotta.petshop.configs.interceptor;

import com.github.rodmotta.petshop.clients.keycloak.KeycloakClient;
import com.github.rodmotta.petshop.dtos.responses.TokenResponse;
import feign.RequestInterceptor;
import feign.RequestTemplate;

import java.time.LocalDateTime;

import static com.github.rodmotta.petshop.dtos.mappers.TokenMapper.keycloakResponseToResponse;

public class KeycloakClientInterceptor implements RequestInterceptor {

    private final KeycloakClient keycloakClient;
    private TokenResponse token;

    public KeycloakClientInterceptor(KeycloakClient keycloakClient) {
        this.keycloakClient = keycloakClient;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        if (token == null) {
            token = keycloakResponseToResponse(keycloakClient.getClientToken());
        }

        if (LocalDateTime.now().isBefore(token.accessTokenExpire())) {
            requestTemplate.header("Authorization", "Bearer " + token.accessToken());
        } else {
            token = keycloakResponseToResponse(keycloakClient.getClientToken());
            requestTemplate.header("Authorization", "Bearer " + token.accessToken());
        }
    }
}
