package br.edu.ifsertaope.cs.api_petshop.auth.facade;

import org.springframework.stereotype.Service;

import br.edu.ifsertaope.cs.api_petshop.user.command.*;
import br.edu.ifsertaope.cs.api_petshop.user.repository.UserRepository;

@Service
public class AuthFacade {

    private final UserRepository repository;

    public AuthFacade(UserRepository repository) {
        this.repository = repository;
    }

    /* LOGIN */
    public String login(String email, String password) {
        return new LoginCommand(repository, email, password).execute();
    }

    /* LOGOUT */
    public void logout(String token) {
        new LogoutCommand(repository, token).execute();
    }
}
