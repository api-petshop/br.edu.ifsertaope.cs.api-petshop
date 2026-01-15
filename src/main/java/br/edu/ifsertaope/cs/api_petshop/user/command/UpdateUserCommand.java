package br.edu.ifsertaope.cs.api_petshop.user.command;

import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.user.entity.User;
import br.edu.ifsertaope.cs.api_petshop.user.repository.UserRepository;

public class UpdateUserCommand implements Command<User> {

    private final UserRepository repository;
    private final Long userId;
    private final User updatedUser;

    public UpdateUserCommand(UserRepository repository, Long userId, User updatedUser) {
        this.repository = repository;
        this.userId = userId;
        this.updatedUser = updatedUser;
    }

    @Override
    public User execute() {
        User user = repository.findById(userId).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setCpf(updatedUser.getCpf());
        user.setPassword(updatedUser.getPassword());
        user.setIsAdmin(updatedUser.getIsAdmin());
        user.setIsActive(updatedUser.getIsActive());

        return repository.save(user);
    }
}
