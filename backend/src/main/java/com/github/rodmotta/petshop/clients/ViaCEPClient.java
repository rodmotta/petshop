package com.github.rodmotta.petshop.clients;

import com.github.rodmotta.petshop.dtos.responses.ViaCEPResponse;
import com.github.rodmotta.petshop.errors.exception.NotFoundException;
import com.github.rodmotta.petshop.errors.exception.ServiceException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ViaCEPClient {

    private final RestClient restClient;

    public ViaCEPClient(@Qualifier("viaCEPRestClient") RestClient restClient) {
        this.restClient = restClient;
    }

    public ViaCEPResponse getAddressByCEP(String CEP) {
        return restClient.get()
                .uri("/ws/{CEP}/json", CEP)
                .retrieve()
                .onStatus(HttpStatusCode::isError, (request, response) -> {
                    throw new NotFoundException("Zipcode not found.");
                })
                .body(ViaCEPResponse.class);
    }
}
