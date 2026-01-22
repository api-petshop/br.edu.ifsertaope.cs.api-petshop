package br.edu.ifsertaope.cs.api_petshop.pet.command;

import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.pet.entity.Pet;
import br.edu.ifsertaope.cs.api_petshop.pet.repository.PetRepository;

public class UpdatePetCommand implements Command<Pet> {

    private final PetRepository repository;
    private final Long petId;
    private final Pet updatedPet;

    public UpdatePetCommand(PetRepository repository, Long PetId, Pet updatedPet) {
        this.repository = repository;
        this.petId = PetId;
        this.updatedPet = updatedPet;
    }

    @Override
    public Pet execute() {
        Pet pet = repository.findById(petId)
                .orElseThrow(() -> new RuntimeException("Pet não encontrado"));

        pet.setName(updatedPet.getName());
        pet.setSpecies(updatedPet.getSpecies());
        pet.setBreed(updatedPet.getBreed());
        pet.setAge(updatedPet.getAge());
        pet.setPrice(updatedPet.getPrice());
        pet.setIsAvailable(updatedPet.getIsAvailable());

        return repository.save(pet);
    }

}
