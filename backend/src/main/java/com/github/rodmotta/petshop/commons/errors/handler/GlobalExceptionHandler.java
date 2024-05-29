package com.github.rodmotta.petshop.commons.errors.handler;

import com.github.rodmotta.petshop.commons.errors.exception.FeignClientException;
import com.github.rodmotta.petshop.commons.errors.exception.NotFoundException;
import com.github.rodmotta.petshop.commons.errors.exception.ServiceException;
import com.github.rodmotta.petshop.commons.errors.exception.UnauthorizedException;
import com.github.rodmotta.petshop.commons.errors.response.ErrorResponse;
import com.github.rodmotta.petshop.commons.errors.response.ValidationResponse;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse notFoundException(NotFoundException exception) {
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .build();
    }

    @ResponseStatus(UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public ErrorResponse unauthorizedException(UnauthorizedException exception) {
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .build();
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse methodArgumentNotValidException(MethodArgumentNotValidException exception) {

        List<ValidationResponse> validations = exception.getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> ValidationResponse.builder()
                        .field(((FieldError) error).getField())
                        .message(error.getDefaultMessage())
                        .build())
                .toList();

        return ErrorResponse.builder()
                .validations(validations)
                .build();
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(ServiceException.class)
    public ErrorResponse serviceException(ServiceException exception) {
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .build();
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(FeignClientException.class)
    public ErrorResponse feignClientException(FeignClientException exception) {
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .build();
    }

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse exception(Exception exception) {

        exception.printStackTrace();
        return ErrorResponse.builder()
                .message("Unmapped error.")
                .build();
    }
}
