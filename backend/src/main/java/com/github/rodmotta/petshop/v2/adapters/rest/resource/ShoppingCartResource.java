package com.github.rodmotta.petshop.v2.adapters.rest.resource;

import com.github.rodmotta.petshop.v2.adapters.rest.request.OrderItemRequest;
import com.github.rodmotta.petshop.v2.core.order.domain.model.OrderItem;
import com.github.rodmotta.petshop.v2.core.order.port.ShoppingCartServicePort;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/shopping-cart")
@Tag(name = "Shopping cart")
@RequiredArgsConstructor
public class ShoppingCartResource {

    private final ShoppingCartServicePort shoppingCartServicePort;

    @ResponseStatus(OK)
    @GetMapping
    public List<OrderItem> getItems() {
        return shoppingCartServicePort.getCustomerCartItems();
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public void addItem(@RequestBody OrderItemRequest request) {
        OrderItem orderItem = new OrderItem(request.getProductId(), request.getQuantity());
        shoppingCartServicePort.addItem(orderItem);
    }

    @ResponseStatus(CREATED)
    @DeleteMapping("/{orderItemId}")
    public void deleteItem(@PathVariable UUID orderItemId) {
        shoppingCartServicePort.deleteItem(orderItemId);
    }
}
