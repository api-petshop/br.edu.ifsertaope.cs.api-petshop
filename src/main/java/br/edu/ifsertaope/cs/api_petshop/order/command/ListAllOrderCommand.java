package br.edu.ifsertaope.cs.api_petshop.order.command;

import java.util.List;

import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.order.entity.Order;
import br.edu.ifsertaope.cs.api_petshop.order.repository.OrderRepository;

public class ListAllOrderCommand implements Command<List<Order>> {

    private final OrderRepository repository;

    public ListAllOrderCommand(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Order> execute() {
        return repository.findAll();
    }

}
