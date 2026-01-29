package br.edu.ifsertaope.cs.api_petshop.product.command;

import java.util.List;
import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.product.entity.Product;
import br.edu.ifsertaope.cs.api_petshop.product.repository.ProductRepository;

public class ListProductsCommand implements Command<List<Product>> {

    private final ProductRepository repository;
    private final String category;

    public ListProductsCommand(ProductRepository repository, String category) {
        this.repository = repository;
        this.category = category;
    }

    @Override
    public List<Product> execute() {
        if (category != null) {
            return repository.findByCategory(category);
        }
        return repository.findAll();
    }

}
