package com.github.rodmotta.petshop.services.impl;

import com.github.rodmotta.petshop.dto.requests.KeycloakCreateUserCredentialRequest;
import com.github.rodmotta.petshop.dto.requests.KeycloakCreateUserRequest;
import com.github.rodmotta.petshop.dto.requests.UserRequest;
import com.github.rodmotta.petshop.dto.responses.TokenResponse;
import com.github.rodmotta.petshop.services.KeycloakService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class KeycloakServiceImpl implements KeycloakService {

    @Override
    public TokenResponse getUserToken(UserRequest req) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("username", req.username());
        form.add("password", req.password());
        form.add("client_id", "gateway");
        form.add("client_secret", "VGjvxU3G88bPGpt2AB3XAneDIoY7JVkI");
        form.add("grant_type", "password");

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(form, headers);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(
                "http://localhost:8080/realms/petshop/protocol/openid-connect/token",
                entity,
                TokenResponse.class);
    }

    @Override
    public void createUser(UserRequest req) {

        String clientAccessToken = getClientToken();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(clientAccessToken);

        KeycloakCreateUserRequest body = new KeycloakCreateUserRequest(
                req.username(), req.email(), req.firstName(), req.lastName(),
                List.of(new KeycloakCreateUserCredentialRequest(false, "password", req.password())),
                true);

        HttpEntity<KeycloakCreateUserRequest> entity = new HttpEntity<>(body, headers);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(
                "http://localhost:8080/admin/realms/petshop/users",
                entity,
                String.class);
    }

    private String getClientToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("client_id", "gateway");
        form.add("client_secret", "VGjvxU3G88bPGpt2AB3XAneDIoY7JVkI");
        form.add("grant_type", "client_credentials");

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(form, headers);

        RestTemplate restTemplate = new RestTemplate();
        TokenResponse response = restTemplate.postForObject(
                "http://localhost:8080/realms/petshop/protocol/openid-connect/token",
                entity,
                TokenResponse.class);

        if (Objects.isNull(response)) {
            throw new RuntimeException();
        }
        return response.accessToken();
    }
}
