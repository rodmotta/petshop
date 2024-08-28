package com.github.rodmotta.petshop.v2.core.user.model;

public interface AuthorizationServer {
    Token login(Credential credential);
    void register(User user);
}
