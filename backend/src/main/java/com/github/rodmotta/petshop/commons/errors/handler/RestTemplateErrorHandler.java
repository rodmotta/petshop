package com.github.rodmotta.petshop.commons.errors.handler;

import com.github.rodmotta.petshop.commons.errors.exception.UnauthorizedException;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

public class RestTemplateErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {

        return response.getStatusCode().isError();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {

        if (response.getStatusCode().equals(UNAUTHORIZED)) {
            throw new UnauthorizedException("Invalid user credentials.");
        } else {
            throw new RuntimeException();
        }
    }
}
