package br.edu.ifsertaope.cs.api_petshop.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsertaope.cs.api_petshop.user.dto.LoginDTO;
import br.edu.ifsertaope.cs.api_petshop.user.entity.User;
import br.edu.ifsertaope.cs.api_petshop.user.facade.UserFacade;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserFacade facade;

    public UserController(UserFacade facade) {
        this.facade = facade;
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return facade.createUser(user);
    }

    @GetMapping
    public List<User> listAll() {
        return facade.listAllUsers();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return facade.findUserbyId(id);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        return facade.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        facade.deleteUser(id);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO dto) {
        return facade.login(dto.getEmail(), dto.getPassword());
    }

    @PostMapping("/logout")
    public void logout(@RequestHeader("Authorization") String token) {
        facade.logout(token);
    }

}
