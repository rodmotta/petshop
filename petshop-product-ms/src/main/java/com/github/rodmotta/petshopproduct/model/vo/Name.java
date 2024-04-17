package com.github.rodmotta.petshopproduct.model.vo;

import java.util.Objects;

public record Name(String value) {
    public Name {
        if (Objects.isNull(value) || value.isEmpty()) {
            throw new RuntimeException();
        }
        if (value.length() > 30) {
            throw new RuntimeException();
        }
    }
}
