package br.edu.ifsertaope.cs.api_petshop.pet.command;

import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.pet.entity.Pet;
import br.edu.ifsertaope.cs.api_petshop.pet.repository.PetRepository;

public class CreatePetCommand implements Command<Pet> {

    private final PetRepository repository;
    private final Pet pet;

    public CreatePetCommand(PetRepository repository, Pet pet) {
        this.repository = repository;
        this.pet = pet;
    }

    @Override
    public Pet execute() {
        return repository.save(pet);
    }
}
