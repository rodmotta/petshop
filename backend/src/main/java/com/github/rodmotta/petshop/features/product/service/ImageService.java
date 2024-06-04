package com.github.rodmotta.petshop.features.product.service;

import com.github.rodmotta.petshop.commons.clients.aws.AwsS3Client;
import com.github.rodmotta.petshop.commons.errors.exception.NotFoundException;
import com.github.rodmotta.petshop.commons.errors.exception.ServiceException;
import com.github.rodmotta.petshop.features.product.persistence.entities.ProductEntity;
import com.github.rodmotta.petshop.features.product.persistence.entities.ImageEntity;
import com.github.rodmotta.petshop.features.product.persistence.repository.ImageRepository;
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
public class ImageService {

    private final AwsS3Client awsS3Client;
    private final ImageRepository imageRepository;
    private final ProductRepository productRepository;

    @Value("${spring.profiles.active}")
    private String profile;

    @Value("${aws.s3.image-bucket}")
    private String bucket;

    public void addImage(UUID productId, MultipartFile image) {

        if (!Objects.equals(image.getContentType(), IMAGE_PNG_VALUE) && !Objects.equals(image.getContentType(), IMAGE_JPEG_VALUE)) {
            throw new ServiceException("Only images in JPEG or PNG format are accepted.");
        }

        ProductEntity product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Product not found."));

        int numberOfImages = product.getImages().size();
        if (numberOfImages >= 5) throw new ServiceException("The product has already reached the image limit.");

        UUID imageId = UUID.randomUUID();
        String path = String.format("%s/%s/%s", profile, productId, imageId);
        awsS3Client.uploadFile(image, bucket, path, image.getContentType());

        ImageEntity productImage = ImageEntity.builder()
                .id(imageId)
                .productId(productId)
                .url(path)
                .position(numberOfImages + 1)
                .build();
        imageRepository.save(productImage);
    }
}
