package com.github.rodmotta.petshop.v2.adapters.config;

import com.github.rodmotta.petshop.v2.adapters.persistence.repository.AddressRepositoryAdapter;
import com.github.rodmotta.petshop.v2.adapters.security.SecurityProviderAdapter;
import com.github.rodmotta.petshop.v2.core.address.service.DeleteAddress;
import com.github.rodmotta.petshop.v2.core.address.service.GetAddress;
import com.github.rodmotta.petshop.v2.core.address.service.SaveAddress;
import com.github.rodmotta.petshop.v2.core.address.service.UpdateAddress;
import com.github.rodmotta.petshop.v2.core.order.port.OrderItemRepositoryPort;
import com.github.rodmotta.petshop.v2.core.order.service.ShoppingCartService;
import com.github.rodmotta.petshop.v2.core.product.model.ProductRepository;
import com.github.rodmotta.petshop.v2.core.product.service.CreateProduct;
import com.github.rodmotta.petshop.v2.core.product.service.UpdateProduct;
import com.github.rodmotta.petshop.v2.core.user.model.AuthorizationServer;
import com.github.rodmotta.petshop.v2.core.user.service.Login;
import com.github.rodmotta.petshop.v2.core.user.service.Register;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public Login login(AuthorizationServer authorizationServer) {
        return new Login(authorizationServer);
    }

    @Bean
    public Register register(AuthorizationServer authorizationServer) {
        return new Register(authorizationServer);
    }

    @Bean
    public CreateProduct createProduct(ProductRepository productRepository) {
        return new CreateProduct(productRepository);
    }

    @Bean
    public UpdateProduct updateProduct(ProductRepository productRepository) {
        return new UpdateProduct(productRepository);
    }

    @Bean
    public GetAddress getAddress(SecurityProviderAdapter securityProviderAdapter, AddressRepositoryAdapter addressRepositoryAdapter) {
        return new GetAddress(securityProviderAdapter, addressRepositoryAdapter);
    }

    @Bean
    public SaveAddress saveAddress(SecurityProviderAdapter securityProviderAdapter, AddressRepositoryAdapter addressRepositoryAdapter) {
        return new SaveAddress(securityProviderAdapter, addressRepositoryAdapter);
    }

    @Bean
    public UpdateAddress updateAddress(SecurityProviderAdapter securityProviderAdapter, AddressRepositoryAdapter addressRepositoryAdapter) {
        return new UpdateAddress(securityProviderAdapter, addressRepositoryAdapter);
    }

    @Bean
    public DeleteAddress deleteAddress(SecurityProviderAdapter securityProviderAdapter, AddressRepositoryAdapter addressRepositoryAdapter) {
        return new DeleteAddress(securityProviderAdapter, addressRepositoryAdapter);
    }

    @Bean
    public ShoppingCartService shoppingCartService(SecurityProviderAdapter securityProviderAdapter, OrderItemRepositoryPort orderItemRepositoryPort) {
        return new ShoppingCartService(securityProviderAdapter, orderItemRepositoryPort);
    }
}
