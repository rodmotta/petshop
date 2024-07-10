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

    public static ProductEntity requestToEntity(ProductRequest req) {
        return ProductEntity.builder()
                .name(req.name())
                .price(req.price())
                .brandId(req.brandId())
                .build();
    }

    public static ProductResponse entityToResponse(ProductEntity entity) {
        return new ProductResponse(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                null
        );
    }

    public static ProductResponse entityToResponse(ProductEntity entity, List<ImageResponse> productImagesResponse) {
        return new ProductResponse(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                productImagesResponse
        );
    }
}
