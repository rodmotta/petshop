package com.github.rodmotta.petshopproduct.domain.vo;

import com.github.rodmotta.petshopproduct.domain.exceptions.InvalidParamException;

import java.util.Objects;

public record Name(String value) {
    public Name {
        if (Objects.isNull(value) || value.isEmpty()) {
            throw new InvalidParamException("Name is mandatory.");
        }
        if (value.length() > 30) {
            throw new InvalidParamException("Name cannot be longer than 30 characters.");
        }
    }
}
