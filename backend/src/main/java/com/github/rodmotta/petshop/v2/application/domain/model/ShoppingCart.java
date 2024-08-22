package com.github.rodmotta.petshop.v2.application.domain.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<OrderItem> items;

    public ShoppingCart(List<OrderItem> items) {
        this.items = new ArrayList<>(items);
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addOrUpdateItemQuantity(OrderItem orderItem) {
        if (orderItem.getQuantity() < 0) throw new IllegalArgumentException("Stock must be greater than zero");
        items.stream()
                .filter(item -> item.getProductId().equals(orderItem.getProductId()))
                .findFirst()
                .ifPresentOrElse(
                        item -> item.setQuantity(orderItem.getQuantity()),
                        () -> items.add(orderItem));
    }
}
