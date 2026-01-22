package br.edu.ifsertaope.cs.api_petshop.order.command;

import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.order.entity.Order;
import br.edu.ifsertaope.cs.api_petshop.order.repository.OrderRepository;

public class FinalizeOrderCommand implements Command<Order> {

    private final OrderRepository repository;
    private final Long orderId;

    public FinalizeOrderCommand(OrderRepository repository, Long orderId) {
        this.repository = repository;
        this.orderId = orderId;
    }

    @Override
    public Order execute() {
        Order order = repository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        if (order.getItems().isEmpty()) {
            throw new RuntimeException("Não é possível finalizar um pedido sem itens");
        }

        new CalculateOrderTotalCommand(order).execute();

        order.setStatus("FINALIZADO");

        return repository.save(order);
    }
}
