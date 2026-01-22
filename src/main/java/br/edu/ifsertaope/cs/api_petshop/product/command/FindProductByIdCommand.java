package br.edu.ifsertaope.cs.api_petshop.product.command;

import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.product.entity.Product;
import br.edu.ifsertaope.cs.api_petshop.product.repository.ProductRepository;

public class FindProductByIdCommand implements Command<Product> {

    private final ProductRepository repository;
    private final Long Id;

    public FindProductByIdCommand(ProductRepository repository, Long Id) {
        this.repository = repository;
        this.Id = Id;
    }

    @Override
    public Product execute() {
        return repository.findById(Id).orElseThrow(() -> new RuntimeException("Produto não encontrado."));
    }

}
