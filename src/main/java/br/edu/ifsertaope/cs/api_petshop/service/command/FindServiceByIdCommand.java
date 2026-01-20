package br.edu.ifsertaope.cs.api_petshop.service.command;

import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.service.entity.PetService;
import br.edu.ifsertaope.cs.api_petshop.service.repository.PetServiceRepository;

public class FindServiceByIdCommand implements Command<PetService> {

    private final PetServiceRepository repository;
    private final Long Id;

    public FindServiceByIdCommand(PetServiceRepository repository, Long Id) {
        this.repository = repository;
        this.Id = Id;
    }

    @Override
    public PetService execute() {
        return repository.findById(Id).orElseThrow(() -> new RuntimeException("Serviço não encontrado."));
    }

}
