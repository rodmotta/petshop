package com.github.rodmotta.petshop.v2.adapters.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Value("${authentication-server.url}")
    private String keycloakBaseUrl;

    @Bean("keycloakRestClient")
    public RestClient keycloakRestClient() {
        return RestClient.create(keycloakBaseUrl);
    }

    @Bean("viaCEPRestClient")
    public RestClient viaCEPRestClient() {
        return RestClient.create("https://viacep.com.br");
    }
}
