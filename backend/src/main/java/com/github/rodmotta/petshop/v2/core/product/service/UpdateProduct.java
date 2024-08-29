package com.github.rodmotta.petshop.v2.core.product.service;

import com.github.rodmotta.petshop.v2.core.product.model.Product;
import com.github.rodmotta.petshop.v2.core.product.model.ProductRepository;
import com.github.rodmotta.petshop.v2.core.shared.exception.NotFoundException;

import java.util.UUID;

public class UpdateProduct {

    private final ProductRepository productRepository;

    public UpdateProduct(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void execute(UUID productCode, Product product) {
        Product productFound = productRepository.findByCode(productCode)
                .orElseThrow(() -> new NotFoundException("Product not found"));
        productFound.disable();
        productRepository.save(productFound);

        Product versionedProduct = productFound.newVersion(product.getName(), product.getPrice());
        productRepository.save(versionedProduct);
    }
}
