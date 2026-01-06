package br.edu.ifsertaope.cs.api_petshop.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsertaope.cs.api_petshop.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
