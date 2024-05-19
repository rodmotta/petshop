package com.github.rodmotta.petshop.commons.configs;

import com.github.rodmotta.petshop.commons.errors.handler.RestTemplateErrorHandler;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .errorHandler(new RestTemplateErrorHandler())
                .build();
    }
}
