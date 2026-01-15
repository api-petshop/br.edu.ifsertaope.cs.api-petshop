package br.edu.ifsertaope.cs.api_petshop.pet.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import br.edu.ifsertaope.cs.api_petshop.pet.entity.Pet;
import br.edu.ifsertaope.cs.api_petshop.pet.facade.PetFacade;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetFacade facade;

    public PetController(PetFacade facade) {
        this.facade = facade;
    }

    @PostMapping
    public Pet create(@RequestBody Pet pet) {
        return facade.createPet(pet);
    }

    @GetMapping("/{id}")
    public Pet findById(@PathVariable Long id) {
        return facade.findPetbyId(id);
    }

    @GetMapping
    public List<Pet> list(
            @RequestParam(required = false) String species,
            @RequestParam(required = false) Boolean isAvailable,
            @RequestParam(required = false) BigDecimal maxPrice) {
        return facade.listAllPets(species, isAvailable, maxPrice);
    }

    @PutMapping("/{id}")
    public Pet update(@PathVariable Long id, @RequestBody Pet pet) {
        return facade.updatePet(id, pet);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        facade.deletePet(id);
    }
}
