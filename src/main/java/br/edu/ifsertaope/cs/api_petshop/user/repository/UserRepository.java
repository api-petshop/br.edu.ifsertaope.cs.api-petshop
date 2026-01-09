package br.edu.ifsertaope.cs.api_petshop.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsertaope.cs.api_petshop.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByAuthToken(String authToken);

}
