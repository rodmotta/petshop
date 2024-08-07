package com.github.rodmotta.petshop.resources;

import com.github.rodmotta.petshop.dtos.requests.CreateUserRequest;
import com.github.rodmotta.petshop.dtos.requests.UserCredentialRequest;
import com.github.rodmotta.petshop.dtos.responses.TokenResponse;
import com.github.rodmotta.petshop.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@Tag(name = "Users")
@RequiredArgsConstructor
public class UserResource {

    private final UserService service;

    @PostMapping("user/token")
    @ResponseStatus(OK)
    public TokenResponse getToken(@RequestBody @Valid UserCredentialRequest userCredential) {
        return service.getToken(userCredential);
    }

    @PostMapping("user")
    @ResponseStatus(CREATED)
    public void createUser(@RequestBody @Valid CreateUserRequest user) {
        service.create(user);
    }
}
