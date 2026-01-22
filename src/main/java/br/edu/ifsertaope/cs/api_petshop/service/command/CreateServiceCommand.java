package br.edu.ifsertaope.cs.api_petshop.service.command;

import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.service.entity.PetService;
import br.edu.ifsertaope.cs.api_petshop.service.repository.PetServiceRepository;

public class CreateServiceCommand implements Command<PetService> {

    private final PetServiceRepository repository;
    private final PetService service;

    public CreateServiceCommand(PetServiceRepository repository, PetService service) {
        this.repository = repository;
        this.service = service;
    }

    @Override
    public PetService execute() {
        return repository.save(service);
    }

}
