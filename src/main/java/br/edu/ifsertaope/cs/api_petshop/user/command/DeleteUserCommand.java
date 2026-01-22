package br.edu.ifsertaope.cs.api_petshop.user.command;

import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.user.repository.UserRepository;

public class DeleteUserCommand implements Command<Void> {

    private final UserRepository repository;
    private final Long Id;

    public DeleteUserCommand(UserRepository repository, Long Id) {
        this.repository = repository;
        this.Id = Id;
    }

    @Override
    public Void execute() {
        repository.deleteById(Id);
        return null;
    }

}
