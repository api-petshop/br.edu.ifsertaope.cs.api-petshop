package br.edu.ifsertaope.cs.api_petshop.service.command;

import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.service.entity.PetService;
import br.edu.ifsertaope.cs.api_petshop.service.repository.PetServiceRepository;;

public class UpdateServiceCommand implements Command<PetService> {

    private final PetServiceRepository repository;
    private final Long Id;
    private final PetService updatedService;

    public UpdateServiceCommand(PetServiceRepository repository, Long Id, PetService updatedService) {
        this.repository = repository;
        this.Id = Id;
        this.updatedService = updatedService;
    }

    @Override
    public PetService execute() {
        PetService service = repository.findById(Id).orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        service.setName(updatedService.getName());
        service.setDescription(updatedService.getDescription());
        service.setPrice(updatedService.getPrice());
        service.setActive(updatedService.getActive());

        return repository.save(service);
    }

}
