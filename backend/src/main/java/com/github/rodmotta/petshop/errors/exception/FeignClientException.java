package com.github.rodmotta.petshop.errors.exception;

public class FeignClientException extends RuntimeException {

    public FeignClientException(String message) {
        super(message);
    }
}
