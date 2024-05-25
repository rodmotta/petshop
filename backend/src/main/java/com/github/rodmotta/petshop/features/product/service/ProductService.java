package com.github.rodmotta.petshop.features.product.service;

import com.github.rodmotta.petshop.features.product.persistence.model.ProductModel;
import com.github.rodmotta.petshop.features.product.persistence.repository.ProductRepository;
import com.github.rodmotta.petshop.features.product.representation.request.ProductRequest;
import com.github.rodmotta.petshop.features.product.representation.responses.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.github.rodmotta.petshop.features.product.mapper.ProductMapper.modelToResponse;
import static com.github.rodmotta.petshop.features.product.mapper.ProductMapper.requestToModel;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse create(ProductRequest productRequest) {

        ProductModel productModel = requestToModel(productRequest);
        ProductModel savedProductModel = productRepository.save(productModel);
        return modelToResponse(savedProductModel);
    }
}
