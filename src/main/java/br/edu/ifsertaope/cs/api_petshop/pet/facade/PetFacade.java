package br.edu.ifsertaope.cs.api_petshop.pet.facade;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifsertaope.cs.api_petshop.pet.repository.PetRepository;
import br.edu.ifsertaope.cs.api_petshop.pet.command.*;
import br.edu.ifsertaope.cs.api_petshop.pet.entity.Pet;

@Service
public class PetFacade {

    private final PetRepository repository;

    public PetFacade(PetRepository repository) {
        this.repository = repository;
    }

    /* CREATE */
    public Pet createPet(Pet pet) {
        return new CreatePetCommand(repository, pet).execute();
    }

    /* READ */
    public List<Pet> listAllPets(String species, Boolean isAvailable, BigDecimal maxPrice) {
        return new ListPetsCommand(repository, species, isAvailable, maxPrice).execute();
    }

    public Pet findPetbyId(Long id) {
        return new FindPetByIdCommand(repository, id).execute();
    }

    /* UPDATE */
    public Pet updatePet(Long id, Pet pet) {
        return new UpdatePetCommand(repository, id, pet).execute();
    }

    /* DELETE */
    public void deletePet(Long id) {
        new DeletePetCommand(repository, id).execute();
    }
}
