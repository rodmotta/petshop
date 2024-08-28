package com.github.rodmotta.petshop.v2.adapters.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(info())
                .externalDocs(externalDocs())
                .addSecurityItem(securityRequirement())
                .components(components());
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

    private SecurityRequirement securityRequirement() {
        return new SecurityRequirement()
                .addList("Bearer Authentication");
    }

    private Components components() {
        return new Components()
                .addSecuritySchemes("Bearer Authentication", securityScheme());
    }

    private SecurityScheme securityScheme() {
        return new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }
}
