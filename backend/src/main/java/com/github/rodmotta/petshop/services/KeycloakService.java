package com.github.rodmotta.petshop.services;

import com.github.rodmotta.petshop.dto.requests.UserRequest;
import com.github.rodmotta.petshop.dto.responses.TokenResponse;

public interface KeycloakService {

    TokenResponse getUserToken(UserRequest req);

    void createUser(UserRequest req);
}
