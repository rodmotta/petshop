package com.github.rodmotta.petshop.dtos.responses;

import com.github.rodmotta.petshop.clients.keycloak.dtos.response.KeycloakToken;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TokenResponse {
    private final String accessToken;
    private final LocalDateTime accessTokenExpire;
    private final String refreshToken;
    private final LocalDateTime refreshTokenExpire;

    public TokenResponse(KeycloakToken keycloakToken) {
        this.accessToken = keycloakToken.access_token();
        this.accessTokenExpire = LocalDateTime.now().plusSeconds(keycloakToken.expires_in());
        this.refreshToken = keycloakToken.refresh_token();
        this.refreshTokenExpire = LocalDateTime.now().plusSeconds(keycloakToken.refresh_expires_in());
    }
}
