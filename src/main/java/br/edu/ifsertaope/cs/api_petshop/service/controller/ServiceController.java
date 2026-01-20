package br.edu.ifsertaope.cs.api_petshop.service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsertaope.cs.api_petshop.service.entity.PetService;
import br.edu.ifsertaope.cs.api_petshop.service.facade.ServiceFacade;

@RestController
@RequestMapping("/services")
public class ServiceController {

    private final ServiceFacade facade;

    public ServiceController(ServiceFacade facade) {
        this.facade = facade;
    }

    @PostMapping
    public PetService create(@RequestBody PetService service) {
        return facade.createService(service);
    }

    @GetMapping
    public List<PetService> listAll() {
        return facade.ListAllServices();
    }

    @GetMapping("/{id}")
    public PetService findById(@PathVariable Long id) {
        return facade.findServiceById(id);
    }

    @PutMapping("/{id}")
    public PetService update(@PathVariable Long id, @RequestBody PetService service) {
        return facade.updateService(id, service);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        facade.deleteService(id);
    }

}
