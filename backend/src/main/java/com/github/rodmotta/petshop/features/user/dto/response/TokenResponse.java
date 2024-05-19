package com.github.rodmotta.petshop.features.user.dto.response;

import com.fasterxml.jackson.annotation.JsonAlias;

public record TokenResponse(
        @JsonAlias("access_token") String accessToken,
        @JsonAlias("expires_in") Integer expiresIn,
        @JsonAlias("refresh_token") String refreshToken,
        @JsonAlias("refresh_expires_in") Integer refreshExpiresIn) {
}
