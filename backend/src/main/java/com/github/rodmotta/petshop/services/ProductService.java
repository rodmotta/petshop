package com.github.rodmotta.petshop.services;

import com.github.rodmotta.petshop.clients.AWSS3Client;
import com.github.rodmotta.petshop.dtos.requests.ProductRequest;
import com.github.rodmotta.petshop.dtos.responses.ImageResponse;
import com.github.rodmotta.petshop.dtos.responses.ProductResponse;
import com.github.rodmotta.petshop.v2.core.shared.exception.NotFoundException;
import com.github.rodmotta.petshop.v2.adapters.persistence.entity.ImageEntity;
import com.github.rodmotta.petshop.v2.adapters.persistence.entity.ProductEntity;
import com.github.rodmotta.petshop.v2.adapters.persistence.repository.jpa.ProductJpaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.github.rodmotta.petshop.dtos.mappers.ProductMapper.entityToResponse;
import static com.github.rodmotta.petshop.dtos.mappers.ProductMapper.requestToEntity;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductJpaRepository productJpaRepository;
    private final AWSS3Client awsS3Client;

    @Value("${aws.s3.image-bucket}")
    private String bucket;

    public void createProduct(ProductRequest productRequest) {
        ProductEntity product = requestToEntity(productRequest);
        product.setCode(UUID.randomUUID());
        //product.setLastVersion(true);
        productJpaRepository.save(product);
    }

    @Transactional
    public void updadteProduct(UUID productCode, ProductRequest productRequest) {
//        ProductEntity product = productJpaRepository.findByCodeAndLastVersionTrue(productCode)
//                .orElseThrow(() -> new NotFoundException("Product not found"));
        //product.setLastVersion(false);
//        productJpaRepository.save(product);

        ProductEntity newProduct = requestToEntity(productRequest);
        newProduct.setCode(productCode);
        //newProduct.setLastVersion(true);
        productJpaRepository.save(newProduct);
    }

    public ProductResponse findById(UUID productId) {
        ProductEntity product = productJpaRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Product not found."));

        List<ImageResponse> productImagesResponse = setProductImagesResponse(product);
        return entityToResponse(product, productImagesResponse);
    }

    public Page<ProductResponse> search(Pageable pageable, String name) {
        Example<ProductEntity> productExample = createProductExample(name);

        Page<ProductEntity> products = productJpaRepository.findAll(productExample, pageable);

        return products.map(product -> {
            ImageResponse imageResponse = setMainProductImageResponse(product)
                    .orElse(null);

            return Objects.isNull(imageResponse)
                    ? entityToResponse(product)
                    : entityToResponse(product, List.of(imageResponse));
        });
    }

    private Example<ProductEntity> createProductExample(String name) {
        ProductEntity product = ProductEntity.builder()
                .name(name)
                .build();

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withMatcher("name", match -> match.contains());

        return Example.of(product, matcher);
    }

    private List<ImageResponse> setProductImagesResponse(ProductEntity product) {
        return product.getImages()
                .stream()
                .map(this::getImageUrl)
                .toList();
    }

    private Optional<ImageResponse> setMainProductImageResponse(ProductEntity product) {
        return product.getImages()
                .stream()
                .min(Comparator.comparing(ImageEntity::getPosition))
                .map(this::getImageUrl);
    }

    private ImageResponse getImageUrl(ImageEntity productImage) {
        String url = awsS3Client.getFileUrl(bucket, productImage.getUrl());
        return new ImageResponse(url, productImage.getPosition());
    }
}
