package com.github.rodmotta.petshop.services;

import com.github.rodmotta.petshop.clients.keycloak.KeycloakClient;
import com.github.rodmotta.petshop.clients.keycloak.dtos.request.RoleRequest;
import com.github.rodmotta.petshop.clients.keycloak.dtos.request.UserRequest;
import com.github.rodmotta.petshop.clients.keycloak.dtos.response.KeycloakToken;
import com.github.rodmotta.petshop.clients.keycloak.dtos.response.RoleResponse;
import com.github.rodmotta.petshop.clients.keycloak.dtos.response.UserResponse;
import com.github.rodmotta.petshop.clients.keycloak.KeycloakAdminClient;
import com.github.rodmotta.petshop.dtos.requests.CreateUserRequest;
import com.github.rodmotta.petshop.dtos.requests.UserCredentialRequest;
import com.github.rodmotta.petshop.dtos.responses.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.github.rodmotta.petshop.enums.Roles.CUSTOMER;

@Service
@RequiredArgsConstructor
public class UserService {

    private final KeycloakAdminClient keycloakAdminClient;
    private final KeycloakClient keycloakClient;
    private final CustomerService customerService;

    public TokenResponse getToken(UserCredentialRequest userCredential) {
        KeycloakToken keycloakToken = keycloakClient.getUserToken(userCredential);
        return new TokenResponse(keycloakToken);
    }

    public void create(CreateUserRequest createUserRequest) {
        UserRequest userRequest = new UserRequest(createUserRequest);
        keycloakAdminClient.createUser(userRequest);

        List<UserResponse> users = keycloakAdminClient.getUsers(createUserRequest.username());
        UserResponse user = users.stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException()); //todo - handling

        List<RoleResponse> roles = keycloakAdminClient.getRealmRoles();
        RoleResponse role = roles.stream()
                .filter(r -> r.name().equals(CUSTOMER.name()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException()); //todo - handling

        RoleRequest roleRequest = new RoleRequest(role.id(), CUSTOMER.name());
        keycloakAdminClient.addRealmRolesToUser(user.id(), List.of(roleRequest));

        customerService.create(user.id(), createUserRequest);
    }
}
