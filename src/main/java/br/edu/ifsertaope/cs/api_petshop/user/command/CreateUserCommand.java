package br.edu.ifsertaope.cs.api_petshop.user.command;

import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.user.entity.User;
import br.edu.ifsertaope.cs.api_petshop.user.repository.UserRepository;

public class CreateUserCommand implements Command<User> {

    private final UserRepository repository;
    private final User user;

    public CreateUserCommand(UserRepository repository, User user) {
        this.repository = repository;
        this.user = user;
    }

    @Override
    public User execute() {
        return repository.save(user);
    }

}
