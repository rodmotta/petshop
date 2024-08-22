package com.github.rodmotta.petshop.v2.application.service;

import com.github.rodmotta.petshop.v2.application.port.OrderItemRepositoryPort;
import com.github.rodmotta.petshop.v2.application.domain.model.OrderItem;
import com.github.rodmotta.petshop.v2.application.domain.model.ShoppingCart;
import com.github.rodmotta.petshop.v2.application.port.ShoppingCartServicePort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ShoppingCartServiceAdapter implements ShoppingCartServicePort {

    private final OrderItemRepositoryPort orderItemRepositoryPort;

    public ShoppingCartServiceAdapter(OrderItemRepositoryPort orderItemRepositoryPort) {
        this.orderItemRepositoryPort = orderItemRepositoryPort;
    }

    @Override
    public void addItem(OrderItem orderItem) {

        List<OrderItem> items = orderItemRepositoryPort.findByCustomerId(orderItem.getCustomerId());
        ShoppingCart shoppingCart = new ShoppingCart(items);
        shoppingCart.addOrUpdateItemQuantity(orderItem);
        orderItemRepositoryPort.save(shoppingCart.getItems());
    }

    @Override
    public List<OrderItem> getCartItems(UUID customerId) {
        return orderItemRepositoryPort.findByCustomerId(customerId);
    }

    @Override
    public void deleteItem(UUID orderItemId, UUID customerId) {
        Optional<OrderItem> ordemItem = orderItemRepositoryPort.findById(orderItemId);
        OrderItem orderItem = ordemItem.orElseThrow(() -> new RuntimeException("")); //fixme
        orderItemRepositoryPort.deleteById(orderItem.getId());
    }
}
