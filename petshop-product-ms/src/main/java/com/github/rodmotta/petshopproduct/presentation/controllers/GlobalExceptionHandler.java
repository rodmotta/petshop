package com.github.rodmotta.petshopproduct.presentation.controllers;

import com.github.rodmotta.petshopproduct.domain.exceptions.InvalidParamException;
import com.github.rodmotta.petshopproduct.domain.exceptions.NotFoundException;
import com.github.rodmotta.petshopproduct.presentation.dto.response.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ErrorResponse notFound(NotFoundException exception) {
        return new ErrorResponse(exception.getMessage());
    }

    @ExceptionHandler(InvalidParamException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse invalidParam(InvalidParamException exception) {
        return new ErrorResponse(exception.getMessage());
    }
}
