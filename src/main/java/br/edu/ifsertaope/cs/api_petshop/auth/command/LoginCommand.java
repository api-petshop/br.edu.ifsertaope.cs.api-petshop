package br.edu.ifsertaope.cs.api_petshop.auth.command;

import java.util.UUID;
import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.user.repository.UserRepository;
import br.edu.ifsertaope.cs.api_petshop.user.entity.User;

public class LoginCommand implements Command<String> {

    private final UserRepository repository;
    private final String email;
    private final String password;

    public LoginCommand(UserRepository repository, String email, String password) {
        this.repository = repository;
        this.email = email;
        this.password = password;
    }

    @Override
    public String execute() {
        User user = repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Senha incorreta");
        }
        if (user.getAuthToken() != null) {
            throw new RuntimeException("Usuário já está logado");
        }
        String token = UUID.randomUUID().toString();
        user.setAuthToken(token);
        repository.save(user);
        return token;
    }

}
