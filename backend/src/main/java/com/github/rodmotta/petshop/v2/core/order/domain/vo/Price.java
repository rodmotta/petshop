package com.github.rodmotta.petshop.v2.core.order.domain.vo;

import java.math.BigDecimal;
import java.util.Objects;

public record Price(BigDecimal amount) {
    public Price {
        if (Objects.isNull(amount) || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }
    }
}
