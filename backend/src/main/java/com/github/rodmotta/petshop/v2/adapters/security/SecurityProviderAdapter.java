package com.github.rodmotta.petshop.v2.adapters.security;

import com.github.rodmotta.petshop.v2.adapters.client.KeycloakAuthorizationServer;
import com.github.rodmotta.petshop.v2.core.shared.SecurityProvider;
import com.github.rodmotta.petshop.v2.core.user.model.Credential;
import com.github.rodmotta.petshop.v2.core.user.model.Token;
import com.github.rodmotta.petshop.v2.core.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SecurityProviderAdapter implements SecurityProvider {

    private final KeycloakAuthorizationServer keycloakAuthorizationServer;

    @Override
    public User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UUID userId = UUID.fromString(authentication.getName());
        return new User(userId, null, null, null, null, null, null);
    }

    @Override
    public Token getToken(Credential credential) {
        return keycloakAuthorizationServer.login(credential);
    }

    @Override
    public void registerUser(User user) {
        keycloakAuthorizationServer.register(user);
    }
}
