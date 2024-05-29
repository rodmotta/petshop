package com.github.rodmotta.petshop.commons.clients.keycloak;

import com.github.rodmotta.petshop.commons.clients.keycloak.representation.response.KeycloakTokenResponse;
import com.github.rodmotta.petshop.features.user.representation.request.UserCredentialRequest;
import com.github.rodmotta.petshop.features.user.representation.response.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED;

@Component
@RequiredArgsConstructor
public class KeycloakClient { //todo - refact

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

        KeycloakTokenResponse response = restTemplate.postForObject(
                String.format("%s/realms/%s/protocol/openid-connect/token", url, realm),
                entity,
                KeycloakTokenResponse.class);

        if (Objects.isNull(response)) {
            throw new RuntimeException();
        }
        return new TokenResponse(response);
    }

    public TokenResponse getClientToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("client_id", clientId);
        form.add("client_secret", clientSecret);
        form.add("grant_type", "client_credentials");

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(form, headers);

        KeycloakTokenResponse response = restTemplate.postForObject(
                String.format("%s/realms/%s/protocol/openid-connect/token", url, realm),
                entity,
                KeycloakTokenResponse.class);

        if (Objects.isNull(response)) {
            throw new RuntimeException();
        }
        return new TokenResponse(response);
    }
}
