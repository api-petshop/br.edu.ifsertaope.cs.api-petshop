package br.edu.ifsertaope.cs.api_petshop.pet.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsertaope.cs.api_petshop.pet.entity.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findBySpecies(String species);

    List<Pet> findByIsAvailable(Boolean isAvailable);

    List<Pet> findByPriceLessThanEqual(BigDecimal price);

    List<Pet> findBySpeciesAndIsAvailable(String species, Boolean isAvailable);

}
