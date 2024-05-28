package com.github.rodmotta.petshop.commons.errors.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
