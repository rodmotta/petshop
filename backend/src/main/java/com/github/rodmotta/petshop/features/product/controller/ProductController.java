package com.github.rodmotta.petshop.features.product.controller;

import com.github.rodmotta.petshop.features.product.representation.request.ProductRequest;
import com.github.rodmotta.petshop.features.product.representation.responses.ProductResponse;
import com.github.rodmotta.petshop.features.product.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

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

    @GetMapping("product/{productId}")
    @ResponseStatus(OK)
    public ProductResponse findById(@PathVariable UUID productId) {
        return productService.findById(productId);
    }
}
