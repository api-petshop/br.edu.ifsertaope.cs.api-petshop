package br.edu.ifsertaope.cs.api_petshop.order.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsertaope.cs.api_petshop.order.entity.Order;
import br.edu.ifsertaope.cs.api_petshop.order.entity.OrderItem;
import br.edu.ifsertaope.cs.api_petshop.order.facade.OrderFacade;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderFacade facade;

    public OrderController(OrderFacade facade) {
        this.facade = facade;
    }

    @PostMapping
    public Order create(@RequestParam Long userId) {
        return facade.createOrder(userId);
    }

    @GetMapping("/user/{userId}")
    public List<Order> listByUser(@PathVariable Long userId) {
        return facade.listByUser(userId);
    }

    @PostMapping("/{orderId}/items")
    public Order addItem(@PathVariable Long orderId, @RequestBody OrderItem item) {
        return facade.addItem(orderId, item);
    }

    @DeleteMapping("/{orderId}/items/{itemId}")
    public Order removeItem(@PathVariable Long orderId, @PathVariable Long itemId) {
        return facade.removeItem(orderId, itemId);
    }

    @GetMapping
    public List<Order> listAll() {
        return facade.listAll();
    }

}
