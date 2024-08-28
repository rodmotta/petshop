package com.github.rodmotta.petshop.v2.core.user.service;

import com.github.rodmotta.petshop.v2.core.shared.UseCaseVoid;
import com.github.rodmotta.petshop.v2.core.user.model.AuthorizationServer;
import com.github.rodmotta.petshop.v2.core.user.model.User;

public class Register implements UseCaseVoid<User> {

    private final AuthorizationServer authorizationServer;

    public Register(AuthorizationServer authorizationServer) {
        this.authorizationServer = authorizationServer;
    }

    @Override
    public void execute(User user) {
        authorizationServer.register(user);
    }
}
