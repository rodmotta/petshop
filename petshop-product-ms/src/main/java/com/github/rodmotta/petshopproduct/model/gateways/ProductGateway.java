package com.github.rodmotta.petshopproduct.model.gateways;

import com.github.rodmotta.petshopproduct.model.entities.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductGateway {
    List<Product> findAll();
    Optional<Product> findById(UUID productId);
    void create(Product product);
    void update(Product product);
    void delete(UUID productId);
}
