package com.github.rodmotta.petshop.dtos.responses;

import java.time.LocalDateTime;

public record TokenResponse(
        String accessToken,
        LocalDateTime accessTokenExpire,
        String refreshToken,
        LocalDateTime refreshTokenExpire
) {
}
