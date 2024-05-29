package com.github.rodmotta.petshop.features.product_image.controller;

import com.github.rodmotta.petshop.features.product_image.service.ProductImageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@Tag(name = "Product image")
@RequiredArgsConstructor
public class ProductImageController {

    private final ProductImageService productImageService;

    @PostMapping("product/{productId}/image")
    @ResponseStatus(CREATED)
    public void addProductImage(@PathVariable UUID productId,
                                @RequestParam MultipartFile image) {
        productImageService.addProductImage(productId, image);
    }
}
