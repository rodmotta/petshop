package com.github.rodmotta.petshop.v2.core.order.port;

import com.github.rodmotta.petshop.v2.core.order.domain.model.OrderItem;

import java.util.List;
import java.util.UUID;

public interface ShoppingCartServicePort {

    void addItem(OrderItem orderItem);
    List<OrderItem> getCustomerCartItems();
    void deleteItem(UUID orderItemId);
}
