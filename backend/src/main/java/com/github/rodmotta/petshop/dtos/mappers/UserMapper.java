package com.github.rodmotta.petshop.dtos.mappers;

import com.github.rodmotta.petshop.dtos.requests.CreateUserRequest;
import com.github.rodmotta.petshop.dtos.requests.CredentialKeycloakRequest;
import com.github.rodmotta.petshop.dtos.requests.UserKeycloakRequest;
import lombok.NoArgsConstructor;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserMapper {

    public static UserKeycloakRequest requestToKeycloakRequest(CreateUserRequest createUserRequest) {
        return new UserKeycloakRequest(
                createUserRequest.username(),
                createUserRequest.email(),
                createUserRequest.firstName(),
                createUserRequest.lastName(),
                List.of(new CredentialKeycloakRequest(false, "password", createUserRequest.password())),
                true
        );
    }
}
