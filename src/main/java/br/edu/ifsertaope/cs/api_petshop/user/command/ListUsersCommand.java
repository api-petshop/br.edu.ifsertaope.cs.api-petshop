package br.edu.ifsertaope.cs.api_petshop.user.command;

import java.util.List;
import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.user.entity.User;
import br.edu.ifsertaope.cs.api_petshop.user.repository.UserRepository;

public class ListUsersCommand implements Command<List<User>> {

    private final UserRepository repository;

    public ListUsersCommand(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> execute() {
        return repository.findAll();
    }

}
