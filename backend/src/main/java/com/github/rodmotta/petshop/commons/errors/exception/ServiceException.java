package com.github.rodmotta.petshop.commons.errors.exception;

public class ServiceException extends RuntimeException {
    public ServiceException(String message) {
        super(message);
    }
}
