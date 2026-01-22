package br.edu.ifsertaope.cs.api_petshop.service.command;

import java.util.List;

import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.service.entity.PetService;
import br.edu.ifsertaope.cs.api_petshop.service.repository.PetServiceRepository;

public class ListServicesCommand implements Command<List<PetService>> {

    private final PetServiceRepository repository;

    public ListServicesCommand(PetServiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PetService> execute() {
        return repository.findAll();
    }

}
