package br.edu.ifsertaope.cs.api_petshop.product.command;

import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.product.entity.Product;
import br.edu.ifsertaope.cs.api_petshop.product.repository.ProductRepository;

public class CreateProductCommand implements Command<Product> {

    private final ProductRepository repository;
    private final Product product;

    public CreateProductCommand(ProductRepository repository, Product product) {
        this.repository = repository;
        this.product = product;
    }

    @Override
    public Product execute() {
        return repository.save(product);
    }
}
