package com.github.rodmotta.petshop.v2.adapters.persistence.repository;

import com.github.rodmotta.petshop.v2.application.domain.model.OrderItem;
import com.github.rodmotta.petshop.v2.adapters.persistence.entity.OrderItemEntity;
import com.github.rodmotta.petshop.v2.adapters.persistence.repository.jpa.OrderItemJpaRepository;
import com.github.rodmotta.petshop.v2.application.port.OrderItemRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class OrderItemRepositoryAdapter implements OrderItemRepositoryPort {

    private final OrderItemJpaRepository jpaRepository;

    public OrderItemRepositoryAdapter(OrderItemJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<OrderItem> findByCustomerId(UUID customerId) {
        List<OrderItemEntity> orderItems = jpaRepository.findByCustomerId(customerId);
        return orderItems.stream()
                .map(orderItem -> new OrderItem(orderItem.getId(), orderItem.getCustomerId(), orderItem.getProductId(), orderItem.getQuantity()))
                .toList();
    }

    @Override
    public void save(List<OrderItem> orderItems) {
        List<OrderItemEntity> orderItemsEntities = orderItems.stream()
                .map(orderItem -> new OrderItemEntity(orderItem.getId(), orderItem.getCustomerId(), orderItem.getProductId(), orderItem.getQuantity()))
                .toList();
        jpaRepository.saveAll(orderItemsEntities);
    }

    @Override
    public Optional<OrderItem> findById(UUID orderItemId) {
        return jpaRepository.findById(orderItemId)
                .map(orderItem -> new OrderItem(orderItem.getId(), orderItem.getCustomerId(), orderItem.getProductId(), orderItem.getQuantity()));
    }

    @Override
    public void deleteById(UUID orderItemId) {
        jpaRepository.deleteById(orderItemId);
    }
}
