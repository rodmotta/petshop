package com.github.rodmotta.petshop.features.user.client;

import com.github.rodmotta.petshop.features.user.client.dto.request.KeycloakCreateUserCredentialRequest;
import com.github.rodmotta.petshop.features.user.client.dto.request.KeycloakCreateUserRequest;
import com.github.rodmotta.petshop.features.user.dto.requests.UserCredentialRequest;
import com.github.rodmotta.petshop.features.user.dto.requests.UserRequest;
import com.github.rodmotta.petshop.features.user.dto.response.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED;

@Component
@RequiredArgsConstructor
public class KeycloakClient {

    private final RestTemplate restTemplate;

    @Value("${authentication-server.url}")
    private String url;

    @Value("${authentication-server.realm}")
    private String realm;

    @Value("${authentication-server.client_id}")
    private String clientId;

    @Value("${authentication-server.client_secret}")
    private String clientSecret;

    public TokenResponse getUserToken(UserCredentialRequest userCredential) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("username", userCredential.username());
        form.add("password", userCredential.password());
        form.add("client_id", clientId);
        form.add("client_secret", clientSecret);
        form.add("grant_type", "password");

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(form, headers);

        return restTemplate.postForObject(
                String.format("%s/realms/%s/protocol/openid-connect/token", url, realm),
                entity,
                TokenResponse.class);
    }

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

        restTemplate.postForObject(
                String.format("%s/admin/realms/%s/users", url, realm),
                entity,
                String.class);
    }

    private String getClientToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("client_id", clientId);
        form.add("client_secret", clientSecret);
        form.add("grant_type", "client_credentials");

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(form, headers);

        TokenResponse response = restTemplate.postForObject(
                String.format("%s/realms/%s/protocol/openid-connect/token", url, realm),
                entity,
                TokenResponse.class);

        if (Objects.isNull(response)) {
            throw new RuntimeException();
        }
        return response.accessToken();
    }
}
