package com.github.rodmotta.petshopproduct.presentation.dto.request;

import java.math.BigDecimal;
import java.util.UUID;

public record UpdateProductRequest(
        UUID id,
        String name,
        String description,
        BigDecimal price,
        UUID categoryId,
        UUID subCategoryId,
        UUID brandId) {
}
