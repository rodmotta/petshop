package com.github.rodmotta.petshop.errors.handler;

import com.github.rodmotta.petshop.errors.exception.FeignClientException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class ViaCEPErrorHandler implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {

        return new FeignClientException("Zipcode not found.");
    }
}
