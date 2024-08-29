package com.github.rodmotta.petshop.v2.core.product.model;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {
    void save(Product product);
    Optional<Product> findByCode(UUID productCode);
}
