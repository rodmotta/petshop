package com.github.rodmotta.petshopproduct.model.vo;

import java.util.Objects;

public record Description(String value) {
    public Description {
        if (Objects.isNull(value) || value.isEmpty()) {
            throw new RuntimeException();
        }
        if (value.length() > 255) {
            throw new RuntimeException();
        }
    }
}
