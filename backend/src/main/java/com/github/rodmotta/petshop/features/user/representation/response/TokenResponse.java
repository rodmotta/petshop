package com.github.rodmotta.petshop.features.user.representation.response;

import com.github.rodmotta.petshop.commons.clients.keycloak.representation.response.KeycloakTokenResponse;
import lombok.Getter;

@Getter
public class TokenResponse {
    private final String accessToken;
    private final Integer expiresIn;
    private final String refreshToken;
    private final Integer refreshExpiresIn;

    public TokenResponse(KeycloakTokenResponse keycloakTokenResponse) {
        this.accessToken = keycloakTokenResponse.access_token();
        this.expiresIn = keycloakTokenResponse.expires_in();
        this.refreshToken = keycloakTokenResponse.refresh_token();
        this.refreshExpiresIn = keycloakTokenResponse.refresh_expires_in();
    }
}
