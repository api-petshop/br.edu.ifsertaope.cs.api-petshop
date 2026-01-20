package br.edu.ifsertaope.cs.api_petshop.auth.controller;

import org.springframework.web.bind.annotation.*;

import br.edu.ifsertaope.cs.api_petshop.auth.dto.LoginRequest;
import br.edu.ifsertaope.cs.api_petshop.auth.facade.AuthFacade;;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthFacade facade;

    public AuthController(AuthFacade facade) {
        this.facade = facade;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return facade.login(request.getEmail(), request.getPassword());
    }

    @PostMapping("/logout")
    public void logout(@RequestHeader("Authorization") String token) {
        facade.logout(token);
    }
}
