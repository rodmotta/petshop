package com.github.rodmotta.petshop.features.product.mapper;

import com.github.rodmotta.petshop.features.product.persistence.entities.ProductEntity;
import com.github.rodmotta.petshop.features.product.representation.request.ProductRequest;
import com.github.rodmotta.petshop.features.product.representation.response.ImageResponse;
import com.github.rodmotta.petshop.features.product.representation.response.ProductResponse;
import lombok.NoArgsConstructor;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ProductMapper {

    public static ProductEntity requestToModel(ProductRequest req) {
        return ProductEntity.builder()
                .name(req.name())
                .price(req.price())
                .brandId(req.brandId())
                .build();
    }

    public static ProductResponse modelToResponse(ProductEntity model) {
        return new ProductResponse(model.getId(), model.getName(), model.getPrice(), null);
    }

    public static ProductResponse modelToResponse(ProductEntity model, List<ImageResponse> productImagesResponse) {
        return new ProductResponse(model.getId(), model.getName(), model.getPrice(), productImagesResponse);
    }
}
