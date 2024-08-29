package com.github.rodmotta.petshop.v2.core.product.service;

import com.github.rodmotta.petshop.v2.core.product.model.Product;
import com.github.rodmotta.petshop.v2.core.product.model.ProductRepository;
import com.github.rodmotta.petshop.v2.core.shared.UseCaseNoArgs;

import java.util.Collections;
import java.util.List;

public class ListProduct implements UseCaseNoArgs<List<Product>> {

    private final ProductRepository productRepository;

    public ListProduct(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> execute() {
        return Collections.emptyList();
    }
}
