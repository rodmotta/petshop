package com.github.rodmotta.petshop.errors.handler;

import com.github.rodmotta.petshop.errors.exception.FeignClientException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class FeignClientErrorHandler implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {

        try {
            InputStream inputStream = response.body().asInputStream();
            String body = IOUtils.toString(inputStream, StandardCharsets.UTF_8);

            //todo - refact
            if (body.contains("User exists with same username")) {
                return new FeignClientException("Username already registered.");
            } else if (body.contains("User exists with same email")) {
                return new FeignClientException("Email already registered.");
            }

            return new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
