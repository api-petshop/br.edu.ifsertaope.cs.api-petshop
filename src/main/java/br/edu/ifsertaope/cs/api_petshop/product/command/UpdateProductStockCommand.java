package br.edu.ifsertaope.cs.api_petshop.product.command;

import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.product.entity.Product;
import br.edu.ifsertaope.cs.api_petshop.product.repository.ProductRepository;

public class UpdateProductStockCommand implements Command<Product> {

    private final ProductRepository repository;
    private final Long productId;
    private final Integer newStock;

    public UpdateProductStockCommand(ProductRepository repository, Long productId, Integer newStock) {
        this.repository = repository;
        this.productId = productId;
        this.newStock = newStock;
    }

    @Override
    public Product execute() {
        Product product = repository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        if (newStock < 0) {
            throw new RuntimeException("Estoque não pode ser negativo");
        }

        product.setStock(newStock);
        return repository.save(product);
    }
}
