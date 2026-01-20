package br.edu.ifsertaope.cs.api_petshop.service.command;

import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.service.repository.PetServiceRepository;

public class DeleteServiceCommand implements Command<Void> {

    private final PetServiceRepository repository;
    private final Long Id;

    public DeleteServiceCommand(PetServiceRepository repository, Long Id) {
        this.repository = repository;
        this.Id = Id;
    }

    @Override
    public Void execute() {
        repository.deleteById(Id);
        return null;
    }
}
