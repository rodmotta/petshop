package com.github.rodmotta.petshopproduct.domain.vo;

import com.github.rodmotta.petshopproduct.domain.exceptions.InvalidParamException;

import java.util.Objects;

public record Description(String value) {
    public Description {
        if (Objects.isNull(value) || value.isEmpty()) {
            throw new InvalidParamException("Name is mandatory.");
        }
        if (value.length() > 255) {
            throw new InvalidParamException("Name cannot be longer than 255 characters.");
        }
    }
}
