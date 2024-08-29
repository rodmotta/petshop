package com.github.rodmotta.petshop.v2.adapters.persistence.repository;

import com.github.rodmotta.petshop.v2.adapters.persistence.entity.ProductEntity;
import com.github.rodmotta.petshop.v2.adapters.persistence.repository.jpa.ProductJpaRepository;
import com.github.rodmotta.petshop.v2.core.product.model.Product;
import com.github.rodmotta.petshop.v2.core.product.model.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryJpa implements ProductRepository {

    private final ProductJpaRepository jpaRepository;

    @Override
    public void save(Product product) {
        ProductEntity productEntity = ProductEntity.builder()
                .id(product.getId())
                .code(product.getCode())
                .version(product.getVersion())
                .active(product.isActive())
                .createdAt(product.getCreatedAt())
                .name(product.getName())
                .price(product.getPrice())
                .build();
        jpaRepository.save(productEntity);
    }

    @Override
    public Optional<Product> findByCode(UUID productCode) {
        return jpaRepository.findByCodeAndActiveTrue(productCode)
                .map(productEntity -> new Product(
                        productEntity.getId(), productEntity.getCode(), productEntity.getVersion(), productEntity.isActive(),
                        productEntity.getCreatedAt(), productEntity.getName(), productEntity.getPrice()));
    }
}
