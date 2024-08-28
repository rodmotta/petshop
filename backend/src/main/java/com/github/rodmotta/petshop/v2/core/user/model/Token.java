package com.github.rodmotta.petshop.v2.core.user.model;

import java.time.LocalDateTime;

public record Token(
        String accessToken,
        LocalDateTime accessTokenExpire,
        String refreshToken,
        LocalDateTime refreshTokenExpire) {
}
