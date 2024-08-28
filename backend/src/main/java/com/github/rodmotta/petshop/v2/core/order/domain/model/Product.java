package com.github.rodmotta.petshop.v2.core.order.domain.model;

import com.github.rodmotta.petshop.v2.core.order.domain.vo.Price;
import com.github.rodmotta.petshop.v2.core.order.domain.vo.Quantity;

import java.util.UUID;

public class Product {

    private final UUID id;
    private String name; //fixme - criar value object
    private Price price;
    private Quantity stock;

    public Product(UUID id) {
        this.id = id;
    }

    public Product(UUID id, String name, Price price, Quantity stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public void addStock(Quantity stock) {
        if (stock.quantity() < 0) throw new IllegalArgumentException("Stock must be greater than zero");
        int newQuantity = this.stock.quantity() + stock.quantity();
        this.stock = new Quantity(newQuantity);
    }

    public void subtractStock(Quantity stock) {
        if (stock.quantity() < 0) throw new IllegalArgumentException("Stock must be greater than zero");
        if (stock.quantity() > this.stock.quantity()) throw new IllegalArgumentException("Stock must be less than available stock");
        int newQuantity = this.stock.quantity() - stock.quantity();
        this.stock = new Quantity(newQuantity);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
