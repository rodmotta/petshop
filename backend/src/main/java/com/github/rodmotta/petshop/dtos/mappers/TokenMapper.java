package com.github.rodmotta.petshop.dtos.mappers;

import com.github.rodmotta.petshop.dtos.responses.TokenKeycloakResponse;
import com.github.rodmotta.petshop.dtos.responses.TokenResponse;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class TokenMapper {

    public static TokenResponse keycloakResponseToResponse(TokenKeycloakResponse keycloakToken) {
        return new TokenResponse(
                keycloakToken.access_token(),
                LocalDateTime.now().plusSeconds(keycloakToken.expires_in()),
                keycloakToken.refresh_token(),
                LocalDateTime.now().plusSeconds(keycloakToken.refresh_expires_in()));
    }
}
