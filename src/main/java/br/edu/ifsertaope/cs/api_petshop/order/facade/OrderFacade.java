package br.edu.ifsertaope.cs.api_petshop.order.facade;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifsertaope.cs.api_petshop.order.command.*;
import br.edu.ifsertaope.cs.api_petshop.order.entity.Order;
import br.edu.ifsertaope.cs.api_petshop.order.repository.OrderRepository;
import br.edu.ifsertaope.cs.api_petshop.product.repository.ProductRepository;
import br.edu.ifsertaope.cs.api_petshop.user.repository.UserRepository;

@Service
public class OrderFacade {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderFacade(
            OrderRepository orderRepository,
            UserRepository userRepository,
            ProductRepository productRepository) {

        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public Order createOrder(Long userId) {
        return new CreateOrderCommand(
                orderRepository,
                userRepository,
                userId).execute();
    }

    public List<Order> listByUser(Long userId) {
        return orderRepository.findByUser_Id(userId);
    }

    public Order addItem(Long orderId, Long productId, Integer quantity) {
        return new AddItemToOrderCommand(
                orderRepository,
                productRepository,
                orderId,
                productId,
                quantity).execute();
    }

    public Order removeItem(Long orderId, Long itemId) {
        return new RemoveOrderItemCommand(orderRepository, orderId, itemId).execute();
    }

    public List<Order> listAll() {
        return new ListAllOrderCommand(orderRepository).execute();
    }

    public Order finalizeOrder(Long orderId) {
        return new FinalizeOrderCommand(orderRepository, orderId).execute();
    }

    public Order findById(Long orderId) {
        return new FindOrderByIdCommand(orderRepository, orderId).execute();
    }

}
