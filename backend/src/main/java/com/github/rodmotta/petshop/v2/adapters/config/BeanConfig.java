package com.github.rodmotta.petshop.v2.adapters.config;

import com.github.rodmotta.petshop.v2.application.service.ShoppingCartServiceAdapter;
import com.github.rodmotta.petshop.v2.application.port.OrderItemRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ShoppingCartServiceAdapter addItemToCartUseCaseAdapter(OrderItemRepositoryPort orderItemRepositoryPort) {
        return new ShoppingCartServiceAdapter(orderItemRepositoryPort);
    }
}
