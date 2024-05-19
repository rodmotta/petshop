package com.github.rodmotta.petshop.commons.configs;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(info())
                .externalDocs(externalDocs());
    }

    private Info info() {
        return new Info().title("Petshop application")
                .description("Petshop API application")
                .version("v0.0.1")
                .license(license());
    }

    private License license() {
        return new License()
                .name("Apache 2.0")
                .url("http://springdoc.org");
    }

    private ExternalDocumentation externalDocs() {
        return new ExternalDocumentation()
                .description("Github Documentation")
                .url("https://github.com/rodmotta/petshop");
    }
}
