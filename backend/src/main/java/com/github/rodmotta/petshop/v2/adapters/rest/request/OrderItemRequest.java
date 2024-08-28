package com.github.rodmotta.petshop.v2.adapters.rest.request;

import lombok.Data;

import java.util.UUID;

@Data
public class OrderItemRequest {

    private UUID productId;
    private int quantity;
}
