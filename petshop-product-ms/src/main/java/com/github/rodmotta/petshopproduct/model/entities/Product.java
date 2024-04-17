package com.github.rodmotta.petshopproduct.model.entities;

import com.github.rodmotta.petshopproduct.model.vo.Description;
import com.github.rodmotta.petshopproduct.model.vo.Name;
import com.github.rodmotta.petshopproduct.model.vo.Price;

import java.util.UUID;

public class Product {
    private UUID id;
    private Name name;
    private Description description;
    private Price price;
    private Category category;
    private SubCategory subCategory;
    private Brand brand;

    public Product(Name name, Description description, Price price, Category category, SubCategory subCategory, Brand brand) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.subCategory = subCategory;
        this.brand = brand;
    }

    public Product(UUID id, Name name, Description description, Price price, Category category, SubCategory subCategory, Brand brand) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.subCategory = subCategory;
        this.brand = brand;
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
}
