package com.github.rodmotta.petshop.features.user.service;

import com.github.rodmotta.petshop.features.user.client.KeycloakClient;
import com.github.rodmotta.petshop.features.user.dto.requests.UserRequest;
import com.github.rodmotta.petshop.features.user.dto.requests.UserCredentialRequest;
import com.github.rodmotta.petshop.features.user.dto.response.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final KeycloakClient keycloakClient;

    public TokenResponse getToken(UserCredentialRequest userCredential) {
        return keycloakClient.getUserToken(userCredential);
    }

    public void create(UserRequest user) {
        keycloakClient.createUser(user);
    }
}
