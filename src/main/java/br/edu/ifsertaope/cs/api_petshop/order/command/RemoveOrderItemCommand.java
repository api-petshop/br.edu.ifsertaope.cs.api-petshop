package br.edu.ifsertaope.cs.api_petshop.order.command;

import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.order.entity.Order;
import br.edu.ifsertaope.cs.api_petshop.order.entity.OrderItem;
import br.edu.ifsertaope.cs.api_petshop.order.repository.OrderRepository;

public class RemoveOrderItemCommand implements Command<Order> {

    private final OrderRepository repository;
    private final Long orderId;
    private final Long itemId;

    public RemoveOrderItemCommand(OrderRepository repository, Long orderId, Long itemId) {
        this.repository = repository;
        this.orderId = orderId;
        this.itemId = itemId;
    }

    @Override
    public Order execute() {
        Order order = repository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        OrderItem itemToRemove = order.getItems().stream()
                .filter(item -> item.getId().equals(itemId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Item não encontrado no pedido"));

        order.getItems().remove(itemToRemove);

        return repository.save(order);
    }
}
