package br.edu.ifsertaope.cs.api_petshop.product.command;

import java.util.List;
import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.product.entity.Product;
import br.edu.ifsertaope.cs.api_petshop.product.repository.ProductRepository;

public class ListProductsCommand implements Command<List<Product>> {

    private final ProductRepository repository;

    public ListProductsCommand(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> execute() {
        return repository.findAll();
    }

}
