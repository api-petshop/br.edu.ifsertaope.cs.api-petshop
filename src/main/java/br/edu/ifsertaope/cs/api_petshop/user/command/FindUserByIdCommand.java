package br.edu.ifsertaope.cs.api_petshop.user.command;

import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.user.entity.User;
import br.edu.ifsertaope.cs.api_petshop.user.repository.UserRepository;

public class FindUserByIdCommand implements Command<User> {

    private final UserRepository repository;
    private final Long Id;

    public FindUserByIdCommand(UserRepository repository, Long Id) {
        this.repository = repository;
        this.Id = Id;
    }

    @Override
    public User execute() {
        return repository.findById(Id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

}
