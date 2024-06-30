package com.github.rodmotta.petshop.clients.keycloak;

import com.github.rodmotta.petshop.configs.interceptor.KeycloakClientInterceptor;
import com.github.rodmotta.petshop.dtos.requests.RoleKeycloakRequest;
import com.github.rodmotta.petshop.dtos.requests.UserKeycloakRequest;
import com.github.rodmotta.petshop.dtos.responses.RoleKeycloakResponse;
import com.github.rodmotta.petshop.dtos.responses.UserKeycloakResponse;
import com.github.rodmotta.petshop.errors.handler.FeignClientErrorHandler;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@FeignClient(value = "keycloak-admin",
        url = "${authentication-server.url}",
        path = "/admin/realms/" + "${authentication-server.realm}",
        configuration = {KeycloakClientInterceptor.class, FeignClientErrorHandler.class})
public interface KeycloakAdminClient {

    @PostMapping("/users")
    void createUser(@RequestBody UserKeycloakRequest userRequest);

    @GetMapping("/users")
    List<UserKeycloakResponse> getUsers(@RequestParam String username);

    @GetMapping("/roles")
    List<RoleKeycloakResponse> getRealmRoles();

    @PostMapping("/users/{userId}/role-mappings/realm")
    void addRealmRolesToUser(@PathVariable UUID userId,
                             @RequestBody List<RoleKeycloakRequest> roles);
}
