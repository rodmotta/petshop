package com.github.rodmotta.petshop.features.product.controller;

import com.github.rodmotta.petshop.features.product.service.ImageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@Tag(name = "Products")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping("product/{productId}/image")
    @ResponseStatus(CREATED)
    public void addImage(@PathVariable UUID productId,
                                @RequestParam MultipartFile image) {
        imageService.addImage(productId, image);
    }
}
