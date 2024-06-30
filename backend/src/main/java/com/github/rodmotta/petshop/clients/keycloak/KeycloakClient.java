package com.github.rodmotta.petshop.clients.keycloak;

import com.github.rodmotta.petshop.dtos.requests.UserCredentialRequest;
import com.github.rodmotta.petshop.dtos.responses.TokenKeycloakResponse;
import com.github.rodmotta.petshop.errors.handler.RestTemplateErrorHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED;

@Component
public class KeycloakClient {

    @Value("${authentication-server.url}")
    private String url;

    @Value("${authentication-server.realm}")
    private String realm;

    @Value("${authentication-server.client_id}")
    private String clientId;

    @Value("${authentication-server.client_secret}")
    private String clientSecret;

    private final RestTemplate restTemplate;

    public KeycloakClient() {
        this.restTemplate = new RestTemplateBuilder()
                .errorHandler(new RestTemplateErrorHandler())
                .build();
    }

    public TokenKeycloakResponse getUserToken(UserCredentialRequest userCredential) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("username", userCredential.username());
        form.add("password", userCredential.password());
        form.add("client_id", clientId);
        form.add("client_secret", clientSecret);
        form.add("grant_type", "password");

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(form, headers);

        return restTemplate.postForObject(url + "/realms/" + realm + "/protocol/openid-connect/token", entity, TokenKeycloakResponse.class);
    }

    public TokenKeycloakResponse getClientToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("client_id", clientId);
        form.add("client_secret", clientSecret);
        form.add("grant_type", "client_credentials");

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(form, headers);

        return restTemplate.postForObject(url + "/realms/" + realm + "/protocol/openid-connect/token", entity, TokenKeycloakResponse.class);
    }
}
