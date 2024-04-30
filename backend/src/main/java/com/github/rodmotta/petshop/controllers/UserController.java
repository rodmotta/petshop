package com.github.rodmotta.petshop.controllers;

import com.github.rodmotta.petshop.services.KeycloakService;
import com.github.rodmotta.petshop.dto.requests.UserRequest;
import com.github.rodmotta.petshop.dto.responses.TokenResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("user")
@Tag(name = "Users")
public class UserController {

    private final KeycloakService keycloakService;

    public UserController(KeycloakService keycloakService) {
        this.keycloakService = keycloakService;
    }

    @PostMapping("token")
    @ResponseStatus(OK)
    public TokenResponse getToken(@RequestBody UserRequest req) {
        return keycloakService.getUserToken(req);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void createUser(@RequestBody UserRequest req) {
        keycloakService.createUser(req);
    }
}
