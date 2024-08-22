package com.github.rodmotta.petshop.v2.application.port;

import com.github.rodmotta.petshop.v2.application.domain.model.OrderItem;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderItemRepositoryPort {

    List<OrderItem> findByCustomerId(UUID customerId);
    void save(List<OrderItem> orderItems);
    Optional<OrderItem> findById(UUID orderItemId);
    void deleteById(UUID orderItemId);
}
