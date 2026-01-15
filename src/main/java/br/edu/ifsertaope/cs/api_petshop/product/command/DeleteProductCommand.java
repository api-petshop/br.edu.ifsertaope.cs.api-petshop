package br.edu.ifsertaope.cs.api_petshop.product.command;

import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.product.repository.ProductRepository;

public class DeleteProductCommand implements Command<Void> {

    private final ProductRepository repository;
    private final Long Id;

    public DeleteProductCommand(ProductRepository repository, Long Id) {
        this.repository = repository;
        this.Id = Id;
    }

    @Override
    public Void execute() {
        repository.deleteById(Id);
        return null;
    }

}
