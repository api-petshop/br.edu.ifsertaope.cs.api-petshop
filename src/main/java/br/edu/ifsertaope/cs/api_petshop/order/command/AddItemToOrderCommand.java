package br.edu.ifsertaope.cs.api_petshop.order.command;

import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.order.entity.Order;
import br.edu.ifsertaope.cs.api_petshop.order.entity.OrderItem;
import br.edu.ifsertaope.cs.api_petshop.order.repository.OrderRepository;
import br.edu.ifsertaope.cs.api_petshop.product.entity.Product;
import br.edu.ifsertaope.cs.api_petshop.product.repository.ProductRepository;

import java.util.Optional;

public class AddItemToOrderCommand implements Command<Order> {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final Long orderId;
    private final Long productId;
    private final Integer quantity;

    public AddItemToOrderCommand(
            OrderRepository orderRepository,
            ProductRepository productRepository,
            Long orderId,
            Long productId,
            Integer quantity) {

        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }

    @Override
    public Order execute() {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        // Verifica se já existe um item com o mesmo produto
        Optional<OrderItem> existingItemOpt = order.getItems().stream()
                .filter(i -> i.getProduct().getId().equals(product.getId()))
                .findFirst();

        if (existingItemOpt.isPresent()) {
            // Atualiza o item existente
            OrderItem existingItem = existingItemOpt.get();
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
            existingItem.setUnitPrice(product.getPrice());
        } else {
            // Cria um novo item
            OrderItem item = new OrderItem();
            item.setProduct(product);
            item.setQuantity(quantity);
            item.setOrder(order);
            item.setUnitPrice(product.getPrice());

            order.getItems().add(item);
        }

        // Recalcula o total do pedido
        new CalculateOrderTotalCommand(order).execute();

        return orderRepository.save(order);
    }
}
