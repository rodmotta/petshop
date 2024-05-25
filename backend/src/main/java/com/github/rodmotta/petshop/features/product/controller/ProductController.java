package com.github.rodmotta.petshop.features.product.controller;

import com.github.rodmotta.petshop.features.product.representation.request.ProductRequest;
import com.github.rodmotta.petshop.features.product.representation.responses.ProductResponse;
import com.github.rodmotta.petshop.features.product.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@Tag(name = "Products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("product")
    @ResponseStatus(CREATED)
    public ProductResponse create(@RequestBody @Valid ProductRequest productRequest) {
        return productService.create(productRequest);
    }
}
