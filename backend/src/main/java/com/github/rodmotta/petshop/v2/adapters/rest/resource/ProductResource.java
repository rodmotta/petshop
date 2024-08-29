package com.github.rodmotta.petshop.v2.adapters.rest.resource;

import com.github.rodmotta.petshop.dtos.requests.ProductRequest;
import com.github.rodmotta.petshop.v2.core.product.model.Product;
import com.github.rodmotta.petshop.v2.core.product.service.CreateProduct;
import com.github.rodmotta.petshop.v2.core.product.service.UpdateProduct;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@Tag(name = "Products")
@RequiredArgsConstructor
public class ProductResource {

    private final CreateProduct createProduct;
    private final UpdateProduct updateProduct;

    //    @GetMapping("products")
//    @ResponseStatus(OK)
//    public Page<ProductResponse> search(@PageableDefault Pageable pageable,
//                                        @RequestParam(required = false) String name) {
//        return productService.search(pageable, name);
//    }

    @PostMapping("product")
    @ResponseStatus(CREATED)
    public void createProduct(@RequestBody @Valid ProductRequest productRequest) {
        Product product = new Product(productRequest.name(), productRequest.price());
        createProduct.execute(product);
    }

    @PutMapping("product/{productCode}")
    @ResponseStatus(NO_CONTENT)
    public void updadteProduct(@PathVariable UUID productCode, @RequestBody @Valid ProductRequest productRequest) {
        Product product = new Product(productRequest.name(), productRequest.price());
        updateProduct.execute(productCode, product);
    }

//
//    @GetMapping("product/{productId}")
//    @ResponseStatus(OK)
//    public ProductResponse findById(@PathVariable UUID productId) {
//        return productService.findById(productId);
//    }
//
//    @PostMapping("product/{productId}/image")
//    @ResponseStatus(CREATED)
//    public void addImage(@PathVariable UUID productId,
//                         @RequestParam MultipartFile image) {
//        imageService.addImage(productId, image);
//    }
}
