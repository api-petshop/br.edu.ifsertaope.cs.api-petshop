package br.edu.ifsertaope.cs.api_petshop.pet.command;

import java.math.BigDecimal;
import java.util.List;

import br.edu.ifsertaope.cs.api_petshop.core.command.Command;
import br.edu.ifsertaope.cs.api_petshop.pet.entity.Pet;
import br.edu.ifsertaope.cs.api_petshop.pet.repository.PetRepository;

public class ListPetsCommand implements Command<List<Pet>> {

    private final PetRepository repository;
    private final String species;
    private final Boolean isAvailable;
    private final BigDecimal maxPrice;

    public ListPetsCommand(PetRepository repository, String species, Boolean isAvailable, BigDecimal maxPrice) {
        this.repository = repository;
        this.species = species;
        this.isAvailable = isAvailable;
        this.maxPrice = maxPrice;
    }

    @Override
    public List<Pet> execute() {

        if (species != null && isAvailable != null) {
            return repository.findBySpeciesAndIsAvailable(species, isAvailable);
        }

        if (species != null) {
            return repository.findBySpecies(species);
        }

        if (isAvailable != null) {
            return repository.findByIsAvailable(isAvailable);
        }

        if (maxPrice != null) {
            return repository.findByPriceLessThanEqual(maxPrice);
        }

        return repository.findAll();
    }
}
