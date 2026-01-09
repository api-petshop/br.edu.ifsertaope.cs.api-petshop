package br.edu.ifsertaope.cs.api_petshop.user.command;

import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.user.repository.UserRepository;
import br.edu.ifsertaope.cs.api_petshop.user.entity.User;

public class LogoutCommand implements Command<Void> {

    private final UserRepository repository;
    private final String token;

    public LogoutCommand(UserRepository repository, String token) {
        this.repository = repository;
        this.token = token;
    }

    @Override
    public Void execute() {
        User user = repository.findByAuthToken(token)
                .orElseThrow(() -> new RuntimeException("Sessão inválido"));
        user.setAuthToken(null);
        repository.save(user);
        return null;
    }

}
