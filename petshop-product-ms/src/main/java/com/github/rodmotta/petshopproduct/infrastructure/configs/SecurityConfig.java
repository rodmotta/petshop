package com.github.rodmotta.petshopproduct.infrastructure.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    String[] getWhiteList = {
            "product/api/product/**",
            "product/api/products"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(req -> req
                        .requestMatchers(GET, getWhiteList).permitAll()
                        .anyRequest().authenticated())
                .oauth2ResourceServer(rsConfig -> rsConfig
                        .jwt(withDefaults()))
                .build();
    }
}
