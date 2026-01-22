package br.edu.ifsertaope.cs.api_petshop.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsertaope.cs.api_petshop.service.entity.PetService;

public interface PetServiceRepository extends JpaRepository<PetService, Long> {

}
