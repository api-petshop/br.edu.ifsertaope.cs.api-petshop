package br.edu.ifsertaope.cs.api_petshop.user.command;

import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.user.entity.User;
import br.edu.ifsertaope.cs.api_petshop.user.repository.UserRepository;

public class CreateUserCommand implements Command<User> {

    private final UserRepository userRepository;
    private final User user;

    public CreateUserCommand(UserRepository userRepository, User user) {
        this.userRepository = userRepository;
        this.user = user;
    }

    @Override
    public User execute() {
        return userRepository.save(user);
    }

}
