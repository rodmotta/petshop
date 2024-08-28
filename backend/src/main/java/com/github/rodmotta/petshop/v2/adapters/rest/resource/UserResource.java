package com.github.rodmotta.petshop.v2.adapters.rest.resource;

import com.github.rodmotta.petshop.dtos.requests.CreateUserRequest;
import com.github.rodmotta.petshop.dtos.requests.CredentialRequest;
import com.github.rodmotta.petshop.v2.core.shared.enums.Role;
import com.github.rodmotta.petshop.v2.core.user.model.Credential;
import com.github.rodmotta.petshop.v2.core.user.model.Token;
import com.github.rodmotta.petshop.v2.core.user.model.User;
import com.github.rodmotta.petshop.v2.core.user.service.Login;
import com.github.rodmotta.petshop.v2.core.user.service.Register;
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

    private final Login login;
    private final Register register;

    @PostMapping("user/token")
    @ResponseStatus(OK)
    public Token getToken(@RequestBody @Valid CredentialRequest credentialRequest) {
        Credential credential = new Credential(credentialRequest.username(), credentialRequest.password()); //fixme - criar um mapper
        return login.execute(credential); // fixme - retornar dto
    }

    @PostMapping("user")
    @ResponseStatus(CREATED)
    public void createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
        User user = new User(null, createUserRequest.firstName(), createUserRequest.lastName(),
                createUserRequest.email(), createUserRequest.username(), createUserRequest.password(), Role.CUSTOMER); //fixme - criar um mapper
        register.execute(user);
    }
}
