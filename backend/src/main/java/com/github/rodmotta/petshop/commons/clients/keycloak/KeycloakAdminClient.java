package com.github.rodmotta.petshop.commons.clients.keycloak;

import com.github.rodmotta.petshop.commons.clients.keycloak.representation.request.RoleRequest;
import com.github.rodmotta.petshop.commons.clients.keycloak.representation.request.UserRequest;
import com.github.rodmotta.petshop.commons.clients.keycloak.representation.response.RoleResponse;
import com.github.rodmotta.petshop.commons.clients.keycloak.representation.response.UserResponse;
import com.github.rodmotta.petshop.commons.configs.interceptor.FeignClientInterceptor;
import com.github.rodmotta.petshop.commons.errors.handler.FeignClientErrorHandler;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@FeignClient(value = "keycloak-admin",
        url = "${authentication-server.url}",
        path = "/admin/realms/" + "${authentication-server.realm}",
        configuration = {FeignClientInterceptor.class, FeignClientErrorHandler.class})
public interface KeycloakAdminClient {

    @PostMapping("/users")
    void createUser(@RequestBody UserRequest userRequest);

    @GetMapping("/users")
    List<UserResponse> getUsers(@RequestParam String username);

    @GetMapping("/roles")
    List<RoleResponse> getRealmRoles();

    @PostMapping("/users/{userId}/role-mappings/realm")
    void addRealmRolesToUser(@PathVariable UUID userId,
                             @RequestBody List<RoleRequest> roles);
}
