package com.github.rodmotta.petshop.v2.adapters.persistence.entity;

import com.github.rodmotta.petshop.enums.OrderStatus;
import com.github.rodmotta.petshop.persistence.entities.CustomerEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    //order number
    @Column(name = "customer_id")
    private UUID customerId;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private BigDecimal totalPrice;
    private LocalDateTime orderDate;

    @OneToMany(mappedBy = "order", fetch = LAZY)
    private List<OrderItemEntity> orderItems;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", insertable = false, updatable = false)
    private CustomerEntity customer;
}
