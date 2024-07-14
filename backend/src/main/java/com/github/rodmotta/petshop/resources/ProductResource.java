package com.github.rodmotta.petshop.resources;

import com.github.rodmotta.petshop.dtos.requests.ProductRequest;
import com.github.rodmotta.petshop.dtos.responses.ProductResponse;
import com.github.rodmotta.petshop.services.ImageService;
import com.github.rodmotta.petshop.services.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@Tag(name = "Products")
@RequiredArgsConstructor
public class ProductResource {

    private final ProductService productService;
    private final ImageService imageService;

    @PostMapping("product")
    @ResponseStatus(CREATED)
    public ProductResponse create(@RequestBody @Valid ProductRequest productRequest) {
        return productService.create(productRequest);
    }

    @GetMapping("products")
    @ResponseStatus(OK)
    public Page<ProductResponse> search(@PageableDefault Pageable pageable,
                                        @RequestParam(required = false) String name) {
        return productService.search(pageable, name);
    }

    @GetMapping("product/{productId}")
    @ResponseStatus(OK)
    public ProductResponse findById(@PathVariable UUID productId) {
        return productService.findById(productId);
    }

    @PostMapping("product/{productId}/image")
    @ResponseStatus(CREATED)
    public void addImage(@PathVariable UUID productId,
                         @RequestParam MultipartFile image) {
        imageService.addImage(productId, image);
    }
}
