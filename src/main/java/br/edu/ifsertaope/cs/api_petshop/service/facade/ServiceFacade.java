package br.edu.ifsertaope.cs.api_petshop.service.facade;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifsertaope.cs.api_petshop.service.repository.PetServiceRepository;
import br.edu.ifsertaope.cs.api_petshop.service.command.*;
import br.edu.ifsertaope.cs.api_petshop.service.entity.PetService;

@Service
public class ServiceFacade {

    private final PetServiceRepository repository;

    public ServiceFacade(PetServiceRepository repository) {
        this.repository = repository;
    }

    /* CREATE */
    public PetService createService(PetService service) {
        return new CreateServiceCommand(repository, service).execute();
    }

    /* READ */
    public List<PetService> ListAllServices() {
        return new ListServicesCommand(repository).execute();
    }

    public PetService findServiceById(Long id) {
        return new FindServiceByIdCommand(repository, id).execute();
    }

    /* UPDATE */
    public PetService updateService(Long id, PetService service) {
        return new UpdateServiceCommand(repository, id, service).execute();
    }

    /* DELETE */
    public void deleteService(Long id) {
        new DeleteServiceCommand(repository, id).execute();
    }

}
