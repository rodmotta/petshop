package com.github.rodmotta.petshop.v2.core.user.service;

import com.github.rodmotta.petshop.v2.core.shared.UseCase;
import com.github.rodmotta.petshop.v2.core.user.model.AuthorizationServer;
import com.github.rodmotta.petshop.v2.core.user.model.Credential;
import com.github.rodmotta.petshop.v2.core.user.model.Token;

public class Login implements UseCase<Credential, Token> {

    private final AuthorizationServer authorizationServer;

    public Login(AuthorizationServer authorizationServer) {
        this.authorizationServer = authorizationServer;
    }

    @Override
    public Token execute(Credential credential) {
        return authorizationServer.login(credential);
    }
}
