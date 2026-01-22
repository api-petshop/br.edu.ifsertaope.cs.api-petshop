package br.edu.ifsertaope.cs.api_petshop.order.command;

import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.order.entity.Order;
import br.edu.ifsertaope.cs.api_petshop.order.entity.OrderItem;
import br.edu.ifsertaope.cs.api_petshop.order.repository.OrderRepository;

public class AddItemToOrderCommand implements Command<Order> {

    private final OrderRepository repository;
    private final Long orderId;
    private final OrderItem item;

    public AddItemToOrderCommand(OrderRepository repository, Long orderId, OrderItem item) {
        this.repository = repository;
        this.orderId = orderId;
        this.item = item;
    }

    @Override
    public Order execute() {
        Order order = repository.findById(orderId).orElseThrow(() -> new RuntimeException("Pedido não encontrado."));

        item.setOrder(order);
        order.getItems().add(item);

        return repository.save(order);

    }

}
