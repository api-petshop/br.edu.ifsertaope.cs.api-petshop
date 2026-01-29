package br.edu.ifsertaope.cs.api_petshop.user.facade;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifsertaope.cs.api_petshop.user.command.*;
import br.edu.ifsertaope.cs.api_petshop.user.entity.User;
import br.edu.ifsertaope.cs.api_petshop.user.repository.UserRepository;

@Service
public class UserFacade {

    private final UserRepository repository;

    public UserFacade(UserRepository repository) {
        this.repository = repository;
    }

    /* CREATE */
    public User createUser(User user) {
        return new CreateUserCommand(repository, user).execute();
    }

    /* READ */
    public List<User> listAllUsers() {
        return new ListUsersCommand(repository).execute();
    }

    public User findUserbyId(Long id) {
        return new FindUserByIdCommand(repository, id).execute();
    }

    /* UPDATE */
    public User updateUser(Long id, User user) {
        return new UpdateUserCommand(repository, id, user).execute();
    }

    /* DELETE */
    public void deleteUser(Long id) {
        new DeleteUserCommand(repository, id).execute();
    }
}
