package com.github.rodmotta.petshopproduct.domain.model;

import com.github.rodmotta.petshopproduct.domain.vo.Description;
import com.github.rodmotta.petshopproduct.domain.vo.Name;
import com.github.rodmotta.petshopproduct.domain.vo.Price;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {
    private UUID id;
    private Name name;
    private Description description;
    private Price price;
    private Category category;
    private SubCategory subCategory;
    private Brand brand;

    public Product() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public static ProductBuilder builder() {
        return new ProductBuilder(new Product());
    }

    public record ProductBuilder(Product product) {

        public ProductBuilder id(UUID id) {
            product.setId(id);
            return this;
        }

        public ProductBuilder name(String name) {
            product.setName(new Name(name));
            return this;
        }

        public ProductBuilder description(String description) {
            product.setDescription(new Description(description));
            return this;
        }

        public ProductBuilder price(BigDecimal price) {
            product.setPrice(new Price(price));
            return this;
        }

        public ProductBuilder category(Category category) {
            product.setCategory(category);
            return this;
        }

        public ProductBuilder subCategory(SubCategory subCategory) {
            product.setSubCategory(subCategory);
            return this;
        }

        public ProductBuilder brand(Brand brand) {
            product.setBrand(brand);
            return this;
        }

        public Product build() {
            return product;
        }
    }
}
