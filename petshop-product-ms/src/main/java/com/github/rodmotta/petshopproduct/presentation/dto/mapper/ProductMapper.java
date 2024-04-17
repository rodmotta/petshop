package com.github.rodmotta.petshopproduct.presentation.dto.mapper;

import com.github.rodmotta.petshopproduct.model.entities.Brand;
import com.github.rodmotta.petshopproduct.model.entities.Category;
import com.github.rodmotta.petshopproduct.model.entities.Product;
import com.github.rodmotta.petshopproduct.model.entities.SubCategory;
import com.github.rodmotta.petshopproduct.model.vo.Description;
import com.github.rodmotta.petshopproduct.model.vo.Name;
import com.github.rodmotta.petshopproduct.model.vo.Price;
import com.github.rodmotta.petshopproduct.presentation.dto.request.CreateProductRequest;
import com.github.rodmotta.petshopproduct.presentation.dto.request.UpdateProductRequest;

public class ProductMapper {
    private ProductMapper() {}

    public static Product converter(CreateProductRequest req) {
        Name name = new Name(req.name());
        Description description = new Description(req.description());
        Price price = new Price(req.price());
        Category category = new Category(req.categoryId());
        SubCategory subCategory = new SubCategory(req.subCategoryId());
        Brand brand = new Brand(req.brandId());
        return new Product(name, description, price, category, subCategory, brand);
    }

    public static Product converter(UpdateProductRequest req) {
        Name name = new Name(req.name());
        Description description = new Description(req.description());
        Price price = new Price(req.price());
        Category category = new Category(req.categoryId());
        SubCategory subCategory = new SubCategory(req.subCategoryId());
        Brand brand = new Brand(req.brandId());
        return new Product(req.id(), name, description, price, category, subCategory, brand);
    }
}
