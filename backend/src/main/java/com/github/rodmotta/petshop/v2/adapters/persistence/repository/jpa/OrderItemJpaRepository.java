package com.github.rodmotta.petshop.v2.adapters.persistence.repository.jpa;

import com.github.rodmotta.petshop.v2.adapters.persistence.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderItemJpaRepository extends JpaRepository<OrderItemEntity, UUID> {
    List<OrderItemEntity> findByCustomerId(UUID customerId);
}
