package com.github.rodmotta.petshop.features.product.service;

import com.github.rodmotta.petshop.commons.clients.aws.AwsS3Client;
import com.github.rodmotta.petshop.features.product.persistence.model.ProductImageModel;
import com.github.rodmotta.petshop.features.product.persistence.model.ProductModel;
import com.github.rodmotta.petshop.features.product.persistence.repository.ProductImageRepository;
import com.github.rodmotta.petshop.features.product.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;
import java.util.UUID;

import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@Service
@RequiredArgsConstructor
public class ProductImageService {

    private final AwsS3Client awsS3Client;
    private final ProductImageRepository productImageRepository;
    private final ProductRepository productRepository;

    @Value("${spring.profiles.active}")
    private String profile;

    @Value("${aws.s3.image-bucket}")
    private String bucket;

    public void addProductImage(UUID productId, MultipartFile image) {

        //todo: validar tamanho do arquivo
        if (Objects.isNull(image) || image.isEmpty()) throw new RuntimeException(); //fixme

        String fileExtension = switch (image.getContentType()) {
            case IMAGE_PNG_VALUE -> ".png";
            case IMAGE_JPEG_VALUE -> ".jpeg";
            default -> throw new RuntimeException(); //fixme
        };


        ProductModel product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException()); //fixme

        int productImageCount = productImageRepository.countByProductId(productId);
        if (productImageCount >= 5) throw new RuntimeException(); //fixme


        UUID productImageId = UUID.randomUUID();
        String path = String.format("%s/%s/%s", profile, productId, productImageId);
        awsS3Client.uploadFile(image, bucket, path + fileExtension);


        ProductImageModel productImage = ProductImageModel.builder()
                .id(productImageId)
                .productId(productId)
                .url(path)
                .position(productImageCount + 1)
                .build();
        productImageRepository.save(productImage);
    }
}
