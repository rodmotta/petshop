package com.github.rodmotta.petshop.features.product.service;

import com.github.rodmotta.petshop.commons.clients.aws.AwsS3Client;
import com.github.rodmotta.petshop.commons.errors.exception.NotFoundException;
import com.github.rodmotta.petshop.features.product.persistence.model.ProductModel;
import com.github.rodmotta.petshop.features.product.persistence.repository.ProductRepository;
import com.github.rodmotta.petshop.features.product.representation.request.ProductRequest;
import com.github.rodmotta.petshop.features.product.representation.responses.ProductImageResponse;
import com.github.rodmotta.petshop.features.product.representation.responses.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.github.rodmotta.petshop.features.product.mapper.ProductMapper.modelToResponse;
import static com.github.rodmotta.petshop.features.product.mapper.ProductMapper.requestToModel;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final AwsS3Client awsS3Client;

    @Value("${aws.s3.image-bucket}")
    private String bucket;

    public ProductResponse create(ProductRequest productRequest) {

        ProductModel productModel = requestToModel(productRequest);
        ProductModel savedProductModel = productRepository.save(productModel);
        return modelToResponse(savedProductModel);
    }

    public ProductResponse findById(UUID productId) {

        ProductModel productModel = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Product not found."));

        List<ProductImageResponse> productImagesResponse = productModel.getProductImages()
                .stream()
                .map(productImage -> {
                    String url = awsS3Client.getFileUrl(bucket, productImage.getUrl());
                    return new ProductImageResponse(url, productImage.getPosition());
                })
                .toList();

        return modelToResponse(productModel, productImagesResponse);
    }
}
