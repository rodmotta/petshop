package com.github.rodmotta.petshop.features.product.representation.response;

import com.github.rodmotta.petshop.features.product_image.representation.response.ProductImageResponse;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record ProductResponse(
        UUID id,
        String name,
        BigDecimal price,
        List<ProductImageResponse> images) {
}
