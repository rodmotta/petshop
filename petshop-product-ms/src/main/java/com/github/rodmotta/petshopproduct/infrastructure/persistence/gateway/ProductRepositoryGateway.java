package com.github.rodmotta.petshopproduct.infrastructure.persistence.gateway;

import com.github.rodmotta.petshopproduct.infrastructure.persistence.entities.ProductEntity;
import com.github.rodmotta.petshopproduct.infrastructure.persistence.mapper.ProductMapper;
import com.github.rodmotta.petshopproduct.infrastructure.persistence.repositories.ProductRepository;
import com.github.rodmotta.petshopproduct.model.entities.Product;
import com.github.rodmotta.petshopproduct.model.gateways.ProductGateway;

import java.util.Optional;
import java.util.UUID;

public class ProductRepositoryGateway implements ProductGateway {
    private final ProductRepository productRepository;

    public ProductRepositoryGateway(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void create(Product product) {
        ProductEntity productEntity = ProductMapper.converter(product);
        productRepository.save(productEntity);
    }

    @Override
    public Optional<Product> findById(UUID productId) {
        return productRepository.findById(productId)
                .map(ProductMapper::converter);
    }

    @Override
    public void update(Product product) {
        ProductEntity productEntity = ProductMapper.converter(product);
        productRepository.save(productEntity);
    }

    @Override
    public void delete(UUID productId) {
        productRepository.deleteById(productId);
    }
}
