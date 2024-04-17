package com.github.rodmotta.petshopproduct.presentation.controllers;

import com.github.rodmotta.petshopproduct.model.entities.Product;
import com.github.rodmotta.petshopproduct.model.usecases.ProductUseCase;
import com.github.rodmotta.petshopproduct.presentation.dto.request.CreateProductRequest;
import com.github.rodmotta.petshopproduct.presentation.dto.request.UpdateProductRequest;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.github.rodmotta.petshopproduct.presentation.dto.mapper.ProductMapper.converter;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("product/api")
public class ProductController {
    private final ProductUseCase productUseCase;

    public ProductController(ProductUseCase productUseCase) {
        this.productUseCase = productUseCase;
    }

    @PostMapping("product")
    @ResponseStatus(CREATED)
    public void create(@RequestBody CreateProductRequest req) {
        Product product = converter(req);
        productUseCase.create(product);
    }

    @PutMapping("product")
    @ResponseStatus(NO_CONTENT)
    public void create(@RequestBody UpdateProductRequest req) {
        Product product = converter(req);
        productUseCase.update(product);
    }

    @DeleteMapping("product/{productId}")
    @ResponseStatus(NO_CONTENT)
    public void deleteById(@PathVariable UUID productId) {
        productUseCase.deleteById(productId);
    }
}
