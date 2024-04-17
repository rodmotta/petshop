package com.github.rodmotta.petshopproduct.presentation.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public record ProductResponse(UUID id, String name, String description, BigDecimal price,
                              CategoryResponse category, SubCategoryResponse subCategory, BrandResponse brand) {
    public ProductResponse(UUID id, String name, String description, BigDecimal price) {
        this(id, name, description, price, null, null, null);
    }
}
