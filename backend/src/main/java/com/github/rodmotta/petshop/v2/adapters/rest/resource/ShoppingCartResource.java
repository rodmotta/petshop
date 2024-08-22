package com.github.rodmotta.petshop.v2.adapters.rest.resource;

import com.github.rodmotta.petshop.dtos.responses.CustomerResponse;
import com.github.rodmotta.petshop.services.CustomerService;
import com.github.rodmotta.petshop.v2.application.port.ShoppingCartServicePort;
import com.github.rodmotta.petshop.v2.application.domain.model.OrderItem;
import com.github.rodmotta.petshop.v2.adapters.rest.request.OrderItemRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/shopping-cart")
public class ShoppingCartResource {

    private final CustomerService customerService;
    private final ShoppingCartServicePort shoppingCartServicePort;

    public ShoppingCartResource(CustomerService customerService, ShoppingCartServicePort shoppingCartServicePort) {
        this.customerService = customerService;
        this.shoppingCartServicePort = shoppingCartServicePort;
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public void addItemToCart(@RequestBody OrderItemRequest request) {
        CustomerResponse customer = customerService.getCustomer(); //fixme - refatorar para nova arquitetura
        OrderItem orderItem = new OrderItem(customer.id(), request.getProductId(), request.getQuantity());
        shoppingCartServicePort.addItem(orderItem);
    }

    @ResponseStatus(OK)
    @GetMapping
    public List<OrderItem> getCartItems() {
        CustomerResponse customer = customerService.getCustomer(); //fixme - refatorar para nova arquitetura
        return shoppingCartServicePort.getCartItems(customer.id());
    }

    @ResponseStatus(CREATED)
    @DeleteMapping("/{orderItemId}")
    public void deleteItemFromCart(@PathVariable UUID orderItemId) {
        CustomerResponse customer = customerService.getCustomer(); //fixme - refatorar para nova arquitetura
        shoppingCartServicePort.deleteItem(orderItemId, customer.id());
    }
}
