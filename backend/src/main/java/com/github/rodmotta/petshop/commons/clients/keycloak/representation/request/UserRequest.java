package com.github.rodmotta.petshop.commons.clients.keycloak.representation.request;

import com.github.rodmotta.petshop.features.user.representation.request.CreateUserRequest;
import lombok.Data;

import java.util.List;

@Data
public class UserRequest {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private List<CredentialRequest> credentials;
    private Boolean enabled;

    public UserRequest(CreateUserRequest createUserRequest) {
        this.username = createUserRequest.username();
        this.email = createUserRequest.email();
        this.firstName = createUserRequest.firstName();
        this.lastName = createUserRequest.lastName();
        this.credentials = List.of(new CredentialRequest(false, "password", createUserRequest.password()));
        this.enabled = true;
    }
}
