package com.github.rodmotta.petshop.v2.core.order.service;

import com.github.rodmotta.petshop.v2.core.order.domain.model.OrderItem;
import com.github.rodmotta.petshop.v2.core.order.domain.model.ShoppingCart;
import com.github.rodmotta.petshop.v2.core.order.port.OrderItemRepositoryPort;
import com.github.rodmotta.petshop.v2.core.order.port.ShoppingCartServicePort;
import com.github.rodmotta.petshop.v2.core.shared.SecurityProvider;
import com.github.rodmotta.petshop.v2.core.user.model.User;

import java.util.List;
import java.util.UUID;

public class ShoppingCartService implements ShoppingCartServicePort {

    private final SecurityProvider securityProvider;
    private final OrderItemRepositoryPort orderItemRepositoryPort;

    public ShoppingCartService(SecurityProvider securityProvider, OrderItemRepositoryPort orderItemRepositoryPort) {
        this.securityProvider = securityProvider;
        this.orderItemRepositoryPort = orderItemRepositoryPort;
    }

    @Override
    public void addItem(OrderItem orderItem) {
        User authenticatedUser = securityProvider.getAuthenticatedUser();
        orderItem.setCustomerId(authenticatedUser.id());
        List<OrderItem> items = orderItemRepositoryPort.findByCustomerId(authenticatedUser.id());
        ShoppingCart shoppingCart = new ShoppingCart(items);
        shoppingCart.addOrUpdateItemQuantity(orderItem);
        orderItemRepositoryPort.save(shoppingCart.getItems());
    }

    @Override
    public List<OrderItem> getCustomerCartItems() {
        User authenticatedUser = securityProvider.getAuthenticatedUser();
        return orderItemRepositoryPort.findByCustomerId(authenticatedUser.id());
    }

    @Override
    public void deleteItem(UUID orderItemId) {
        OrderItem orderItem = orderItemRepositoryPort.findById(orderItemId)
                .orElseThrow(() -> new RuntimeException()); //fixme
        User authenticatedUser = securityProvider.getAuthenticatedUser();
        if (!orderItem.getCustomerId().equals(authenticatedUser.id())) throw new RuntimeException(); //fixme
        orderItemRepositoryPort.deleteById(orderItem.getId());
    }
}
