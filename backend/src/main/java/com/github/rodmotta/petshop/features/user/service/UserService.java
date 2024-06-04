package com.github.rodmotta.petshop.features.user.service;

import com.github.rodmotta.petshop.commons.clients.keycloak.KeycloakAdminClient;
import com.github.rodmotta.petshop.commons.clients.keycloak.KeycloakClient;
import com.github.rodmotta.petshop.commons.clients.keycloak.representation.request.RoleRequest;
import com.github.rodmotta.petshop.commons.clients.keycloak.representation.request.UserRequest;
import com.github.rodmotta.petshop.commons.clients.keycloak.representation.response.RoleResponse;
import com.github.rodmotta.petshop.commons.clients.keycloak.representation.response.UserResponse;
import com.github.rodmotta.petshop.features.customer.service.CustomerService;
import com.github.rodmotta.petshop.features.user.representation.request.CreateUserRequest;
import com.github.rodmotta.petshop.features.user.representation.request.UserCredentialRequest;
import com.github.rodmotta.petshop.features.user.representation.response.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.github.rodmotta.petshop.commons.enums.Roles.CUSTOMER;

@Service
@RequiredArgsConstructor
public class UserService {

    private final KeycloakAdminClient keycloakAdminClient;
    private final KeycloakClient keycloakClient;
    private final CustomerService customerService;

    public TokenResponse getToken(UserCredentialRequest userCredential) {
        return keycloakClient.getUserToken(userCredential);
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
