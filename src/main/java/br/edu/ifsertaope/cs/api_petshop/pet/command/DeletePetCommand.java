package br.edu.ifsertaope.cs.api_petshop.pet.command;

import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.pet.repository.PetRepository;;

public class DeletePetCommand implements Command<Void> {

    private final PetRepository repository;
    private final Long Id;

    public DeletePetCommand(PetRepository repository, Long Id) {
        this.repository = repository;
        this.Id = Id;
    }

    @Override
    public Void execute() {
        repository.deleteById(Id);
        return null;
    }

}
