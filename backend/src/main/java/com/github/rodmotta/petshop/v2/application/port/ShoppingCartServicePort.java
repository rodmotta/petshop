package com.github.rodmotta.petshop.v2.application.port;

import com.github.rodmotta.petshop.v2.application.domain.model.OrderItem;

import java.util.List;
import java.util.UUID;

public interface ShoppingCartServicePort {

    void addItem(OrderItem orderItem);
    List<OrderItem> getCartItems(UUID customerId);
    void deleteItem(UUID orderItemId, UUID id);
}
