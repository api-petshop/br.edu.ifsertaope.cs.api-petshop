package br.edu.ifsertaope.cs.api_petshop.pet.command;

import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.pet.entity.Pet;
import br.edu.ifsertaope.cs.api_petshop.pet.repository.PetRepository;

public class FindPetByIdCommand implements Command<Pet> {

    private final PetRepository repository;
    private final Long Id;

    public FindPetByIdCommand(PetRepository repository, Long Id) {
        this.repository = repository;
        this.Id = Id;
    }

    @Override
    public Pet execute() {
        return repository.findById(Id).orElseThrow(() -> new RuntimeException("Pet não encontrado."));
    }

}
