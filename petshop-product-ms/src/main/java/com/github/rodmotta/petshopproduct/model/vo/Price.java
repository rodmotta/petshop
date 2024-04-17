package com.github.rodmotta.petshopproduct.model.vo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public record Price(BigDecimal value) {
    public Price {
        if (Objects.isNull(value)) {
            throw new RuntimeException();
        }
        if (value.compareTo(BigDecimal.ZERO) <= 0 || value.compareTo(BigDecimal.valueOf(100000)) >= 0) {
            throw new RuntimeException();
        }
    }

    @Override
    public BigDecimal value() {
        return value.setScale(2, RoundingMode.CEILING);
    }
}
