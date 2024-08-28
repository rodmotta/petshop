package com.github.rodmotta.petshop.v2.core.shared;

import com.github.rodmotta.petshop.v2.core.user.model.User;
import com.github.rodmotta.petshop.v2.core.user.model.Credential;
import com.github.rodmotta.petshop.v2.core.user.model.Token;

public interface SecurityProvider {
    User getAuthenticatedUser();
    Token getToken(Credential credential);
    void registerUser(User user);
}
