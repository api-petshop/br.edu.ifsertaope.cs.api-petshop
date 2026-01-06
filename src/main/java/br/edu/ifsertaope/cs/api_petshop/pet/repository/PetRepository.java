package br.edu.ifsertaope.cs.api_petshop.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsertaope.cs.api_petshop.pet.entity.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

}
