package com.github.rodmotta.petshop.commons.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(configurer -> configurer.disable())
                .authorizeHttpRequests(req -> req
                        .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
                        .requestMatchers(POST, "/user/token", "/user").permitAll()
                        .requestMatchers(GET, "/products").permitAll()
                        .anyRequest().authenticated())
                .oauth2ResourceServer(configurer -> configurer.jwt(withDefaults()))
                .sessionManagement(configurer -> configurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors(configurer -> configurer.configurationSource(corsConfigurationSource()))
                .build();
    }

    private CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedHeaders(List.of("Content-Type" /*"Authorization", "Cache-Control"*/));
        configuration.setAllowedOrigins(List.of("http://localhost:5173"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
//        configuration.setAllowCredentials(true);
        configuration.setExposedHeaders(List.of("Access-Control-Allow-Origin" /*"Authorization", "Access-Control-Allow-Credentials"*/));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
