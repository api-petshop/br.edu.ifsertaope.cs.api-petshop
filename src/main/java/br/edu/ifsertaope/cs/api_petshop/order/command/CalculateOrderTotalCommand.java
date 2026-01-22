package br.edu.ifsertaope.cs.api_petshop.order.command;

import java.math.BigDecimal;

import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.order.entity.Order;
import br.edu.ifsertaope.cs.api_petshop.order.entity.OrderItem;

public class CalculateOrderTotalCommand implements Command<BigDecimal> {

    private final Order order;

    public CalculateOrderTotalCommand(Order order) {
        this.order = order;
    }

    @Override
    public BigDecimal execute() {
        BigDecimal total = BigDecimal.ZERO;

        for (OrderItem item : order.getItems()) {
            BigDecimal itemTotal = item.getProduct()
                    .getPrice()
                    .multiply(BigDecimal.valueOf(item.getQuantity()));

            total = total.add(itemTotal);
        }

        order.setTotalValue(total);
        return total;
    }
}
