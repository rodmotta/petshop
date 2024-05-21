package com.github.rodmotta.petshop.commons.configs.interceptor;

import com.github.rodmotta.petshop.commons.clients.keycloak.KeycloakClient;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FeignClientInterceptor implements RequestInterceptor {

    private final KeycloakClient keycloakClient;

    @Override
    public void apply(RequestTemplate requestTemplate) {

        String token = keycloakClient.getClientToken().getAccessToken();
        requestTemplate.header("Authorization", "Bearer " + token);
    }
}
