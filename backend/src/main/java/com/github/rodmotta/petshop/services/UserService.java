package com.github.rodmotta.petshop.services;

import com.github.rodmotta.petshop.clients.keycloak.KeycloakAdminClient;
import com.github.rodmotta.petshop.clients.keycloak.KeycloakClient;
import com.github.rodmotta.petshop.dtos.requests.CreateUserRequest;
import com.github.rodmotta.petshop.dtos.requests.RoleKeycloakRequest;
import com.github.rodmotta.petshop.dtos.requests.UserCredentialRequest;
import com.github.rodmotta.petshop.dtos.requests.UserKeycloakRequest;
import com.github.rodmotta.petshop.dtos.responses.RoleKeycloakResponse;
import com.github.rodmotta.petshop.dtos.responses.TokenKeycloakResponse;
import com.github.rodmotta.petshop.dtos.responses.TokenResponse;
import com.github.rodmotta.petshop.dtos.responses.UserKeycloakResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.github.rodmotta.petshop.dtos.mappers.TokenMapper.keycloakResponseToResponse;
import static com.github.rodmotta.petshop.dtos.mappers.UserMapper.requestToKeycloakRequest;
import static com.github.rodmotta.petshop.enums.Roles.CUSTOMER;

@Service
@RequiredArgsConstructor
public class UserService {

    private final KeycloakAdminClient keycloakAdminClient;
    private final KeycloakClient keycloakClient;
    private final CustomerService customerService;

    public TokenResponse getToken(UserCredentialRequest userCredential) {
        TokenKeycloakResponse keycloakToken = keycloakClient.getUserToken(userCredential);
        return keycloakResponseToResponse(keycloakToken);
    }

    public void create(CreateUserRequest createUserRequest) {
        UserKeycloakRequest userRequest = requestToKeycloakRequest(createUserRequest);
        keycloakAdminClient.createUser(userRequest);

        List<UserKeycloakResponse> users = keycloakAdminClient.getUsers(createUserRequest.username());
        UserKeycloakResponse user = users.stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException()); //todo - handling

        List<RoleKeycloakResponse> roles = keycloakAdminClient.getRealmRoles();
        RoleKeycloakResponse role = roles.stream()
                .filter(r -> r.name().equals(CUSTOMER.name()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException()); //todo - handling

        RoleKeycloakRequest roleRequest = new RoleKeycloakRequest(role.id(), CUSTOMER.name());
        keycloakAdminClient.addRealmRolesToUser(user.id(), List.of(roleRequest));

        customerService.create(user.id(), createUserRequest);
    }
}
