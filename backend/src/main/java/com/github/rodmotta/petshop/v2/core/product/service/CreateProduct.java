package com.github.rodmotta.petshop.v2.core.product.service;

import com.github.rodmotta.petshop.v2.core.product.model.Product;
import com.github.rodmotta.petshop.v2.core.product.model.ProductRepository;
import com.github.rodmotta.petshop.v2.core.shared.UseCaseVoid;

public class CreateProduct implements UseCaseVoid<Product> {

    private final ProductRepository productRepository;

    public CreateProduct(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void execute(Product product) {
        productRepository.save(product);
    }
}
