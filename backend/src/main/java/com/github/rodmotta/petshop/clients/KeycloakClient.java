package com.github.rodmotta.petshop.clients;

import com.github.rodmotta.petshop.dtos.requests.RoleKeycloakRequest;
import com.github.rodmotta.petshop.dtos.requests.UserCredentialRequest;
import com.github.rodmotta.petshop.dtos.requests.UserKeycloakRequest;
import com.github.rodmotta.petshop.dtos.responses.RoleKeycloakResponse;
import com.github.rodmotta.petshop.dtos.responses.TokenKeycloakResponse;
import com.github.rodmotta.petshop.dtos.responses.TokenResponse;
import com.github.rodmotta.petshop.dtos.responses.UserKeycloakResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static com.github.rodmotta.petshop.dtos.mappers.TokenMapper.keycloakResponseToResponse;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class KeycloakClient {

    @Value("${authentication-server.realm}")
    private String realm;
    @Value("${authentication-server.client_id}")
    private String clientId;
    @Value("${authentication-server.client_secret}")
    private String clientSecret;

    private final RestClient restClient;
    private TokenResponse clientToken;

    public KeycloakClient(@Qualifier("keycloakRestClient") RestClient restClient) {
        this.restClient = restClient;
    }

    public TokenKeycloakResponse getUserToken(UserCredentialRequest userCredential) {
        fetchClientToken();
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("username", userCredential.username());
        form.add("password", userCredential.password());
        form.add("client_id", clientId);
        form.add("client_secret", clientSecret);
        form.add("grant_type", "password");

        return restClient.post()
                .uri("/realms/{realm}/protocol/openid-connect/token", realm)
                .header(AUTHORIZATION, "Bearer " + clientToken.accessToken())
                .contentType(APPLICATION_FORM_URLENCODED)
                .body(form)
                .retrieve()
                .body(TokenKeycloakResponse.class);
    }

    public void createUser(UserKeycloakRequest userRequest) {
        fetchClientToken();
        restClient.post()
                .uri("/admin/realms/{realm}/users", realm)
                .header(AUTHORIZATION, "Bearer " + clientToken.accessToken())
                .contentType(APPLICATION_FORM_URLENCODED)
                .body(userRequest)
                .retrieve()
                .toBodilessEntity();
    }

    public List<UserKeycloakResponse> getUsers(String username) {
        fetchClientToken();
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/admin/realms/{realm}/users")
                        .queryParam("username", username)
                        .build(realm))
                .header(AUTHORIZATION, "Bearer " + clientToken.accessToken())
                .retrieve()
                .body(ParameterizedTypeReference.forType(UserKeycloakResponse.class));
    }

    public List<RoleKeycloakResponse> getRealmRoles() {
        fetchClientToken();
        return restClient.get()
                .uri("/admin/realms/{realm}/roles", realm)
                .header(AUTHORIZATION, "Bearer " + clientToken.accessToken())
                .retrieve()
                .body(ParameterizedTypeReference.forType(RoleKeycloakResponse.class));
    }

    public void addRealmRolesToUser(UUID userId, List<RoleKeycloakRequest> roles) {
        fetchClientToken();
        restClient.post()
                .uri("/admin/realms/{realm}/users/{userId}/role-mappings/realm", realm, userId)
                .header(AUTHORIZATION, "Bearer " + clientToken.accessToken())
                .contentType(APPLICATION_JSON)
                .body(roles)
                .retrieve()
                .toBodilessEntity();
    }

    private void fetchClientToken() {
        if (clientToken == null || !isTokenValid()) {
            TokenKeycloakResponse token = getClientToken();
            clientToken = keycloakResponseToResponse(token);
        }
    }

    private Boolean isTokenValid() {
        return clientToken.accessTokenExpire().isAfter(LocalDateTime.now());
    }

    private TokenKeycloakResponse getClientToken() {
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("client_id", clientId);
        form.add("client_secret", clientSecret);
        form.add("grant_type", "client_credentials");

        return restClient.post()
                .uri("/realms/{realm}/protocol/openid-connect/token", realm)
                .contentType(APPLICATION_FORM_URLENCODED)
                .body(form)
                .retrieve()
                .body(TokenKeycloakResponse.class);
    }
}
