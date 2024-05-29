package com.github.rodmotta.petshop.features.product.service;

import com.github.rodmotta.petshop.commons.clients.aws.AwsS3Client;
import com.github.rodmotta.petshop.commons.errors.exception.NotFoundException;
import com.github.rodmotta.petshop.features.product.persistence.model.ProductModel;
import com.github.rodmotta.petshop.features.product.persistence.repository.ProductRepository;
import com.github.rodmotta.petshop.features.product.representation.request.ProductRequest;
import com.github.rodmotta.petshop.features.product_image.representation.response.ProductImageResponse;
import com.github.rodmotta.petshop.features.product.representation.response.ProductResponse;
import com.github.rodmotta.petshop.features.product_image.persistence.model.ProductImageModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

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

        ProductModel product = requestToModel(productRequest);
        ProductModel savedProduct = productRepository.save(product);
        return modelToResponse(savedProduct);
    }

    public ProductResponse findById(UUID productId) {

        ProductModel product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Product not found."));

        List<ProductImageResponse> productImagesResponse = setProductImagesResponse(product);

        return modelToResponse(product, productImagesResponse);
    }

    public Page<ProductResponse> search(Pageable pageable, String name) {

        Example<ProductModel> productExample = createProductExample(name);

        Page<ProductModel> products = productRepository.findAll(productExample, pageable);

        return products.map(product -> {

            ProductImageResponse imageResponse = setMainProductImageResponse(product)
                    .orElse(null);

            return Objects.isNull(imageResponse)
                    ? modelToResponse(product)
                    : modelToResponse(product, List.of(imageResponse));
        });
    }

    private Example<ProductModel> createProductExample(String name) {

        ProductModel product = ProductModel.builder()
                .name(name)
                .build();

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withMatcher("name", match -> match.contains());

        return Example.of(product, matcher);
    }

    private List<ProductImageResponse> setProductImagesResponse(ProductModel product) {

        return product.getProductImages()
                .stream()
                .map(this::getImageUrl)
                .toList();
    }

    private Optional<ProductImageResponse> setMainProductImageResponse(ProductModel product) {

        return product.getProductImages()
                .stream()
                .min(Comparator.comparing(ProductImageModel::getPosition))
                .map(this::getImageUrl);
    }

    private ProductImageResponse getImageUrl(ProductImageModel productImage) {

        String url = awsS3Client.getFileUrl(bucket, productImage.getUrl());
        return new ProductImageResponse(url, productImage.getPosition());
    }
}
