package com.github.rodmotta.petshopproduct.domain.vo;

import com.github.rodmotta.petshopproduct.domain.exceptions.InvalidParamException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public record Price(BigDecimal value) {
    public Price {
        if (Objects.isNull(value)) {
            throw new InvalidParamException("Price is mandatory.");
        }
        if (value.compareTo(BigDecimal.ZERO) <= 0 || value.compareTo(BigDecimal.valueOf(100000)) >= 0) {
            throw new InvalidParamException("Price must be between 0.01 to 999999.99");
        }
    }

    @Override
    public BigDecimal value() {
        return value.setScale(2, RoundingMode.CEILING);
    }
}
