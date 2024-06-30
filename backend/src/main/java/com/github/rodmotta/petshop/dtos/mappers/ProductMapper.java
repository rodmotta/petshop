package com.github.rodmotta.petshop.dtos.mappers;

import com.github.rodmotta.petshop.dtos.requests.ProductRequest;
import com.github.rodmotta.petshop.dtos.responses.ImageResponse;
import com.github.rodmotta.petshop.dtos.responses.ProductResponse;
import com.github.rodmotta.petshop.persistence.entities.ProductEntity;
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
        return new ProductResponse(
                model.getId(),
                model.getName(),
                model.getPrice(),
                null
        );
    }

    public static ProductResponse modelToResponse(ProductEntity model, List<ImageResponse> productImagesResponse) {
        return new ProductResponse(
                model.getId(),
                model.getName(),
                model.getPrice(),
                productImagesResponse
        );
    }
}
