package br.edu.ifsertaope.cs.api_petshop.order.command;

import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.order.entity.Order;
import br.edu.ifsertaope.cs.api_petshop.order.repository.OrderRepository;

public class FindOrderByIdCommand implements Command<Order> {

    private final OrderRepository repository;
    private final Long orderId;

    public FindOrderByIdCommand(OrderRepository repository, Long orderId) {
        this.repository = repository;
        this.orderId = orderId;
    }

    @Override
    public Order execute() {
        return repository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }
}
