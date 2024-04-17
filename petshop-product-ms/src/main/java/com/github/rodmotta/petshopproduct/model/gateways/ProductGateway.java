package com.github.rodmotta.petshopproduct.model.gateways;

import com.github.rodmotta.petshopproduct.model.entities.Product;

import java.util.Optional;
import java.util.UUID;

public interface ProductGateway {
    void create(Product product);
    Optional<Product> findById(UUID productId);
    void update(Product product);
    void delete(UUID productId);
}
