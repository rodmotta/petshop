package com.github.rodmotta.petshop.features.product.mapper;

import com.github.rodmotta.petshop.features.product.persistence.model.ProductModel;
import com.github.rodmotta.petshop.features.product.representation.request.ProductRequest;
import com.github.rodmotta.petshop.features.product.representation.responses.ProductImageResponse;
import com.github.rodmotta.petshop.features.product.representation.responses.ProductResponse;
import lombok.NoArgsConstructor;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ProductMapper {

    public static ProductModel requestToModel(ProductRequest req) {
        return ProductModel.builder()
                .name(req.name())
                .price(req.price())
                .build();
    }

    public static ProductResponse modelToResponse(ProductModel model) {
        return new ProductResponse(model.getId(), model.getName(), model.getPrice(), null);
    }

    public static ProductResponse modelToResponse(ProductModel model, List<ProductImageResponse> productImagesResponse) {
        return new ProductResponse(model.getId(), model.getName(), model.getPrice(), productImagesResponse);
    }
}
