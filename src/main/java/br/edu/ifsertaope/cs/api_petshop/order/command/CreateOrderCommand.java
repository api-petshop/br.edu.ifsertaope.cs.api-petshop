package br.edu.ifsertaope.cs.api_petshop.order.command;

import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.order.entity.Order;
import br.edu.ifsertaope.cs.api_petshop.order.repository.OrderRepository;
import br.edu.ifsertaope.cs.api_petshop.user.entity.User;
import br.edu.ifsertaope.cs.api_petshop.user.repository.UserRepository;

public class CreateOrderCommand implements Command<Order> {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final Long userId;

    public CreateOrderCommand(
            OrderRepository orderRepository,
            UserRepository userRepository,
            Long userId) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.userId = userId;
    }

    @Override
    public Order execute() {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Order order = new Order();
        order.setUser(user);

        return orderRepository.save(order);
    }
}
