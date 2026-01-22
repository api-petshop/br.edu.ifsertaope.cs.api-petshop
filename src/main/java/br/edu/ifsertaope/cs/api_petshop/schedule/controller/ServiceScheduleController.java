package br.edu.ifsertaope.cs.api_petshop.schedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsertaope.cs.api_petshop.schedule.entity.ServiceSchedule;
import br.edu.ifsertaope.cs.api_petshop.schedule.facade.ServiceScheduleFacade;

@RestController
@RequestMapping("/service-schedules")
public class ServiceScheduleController {

    @Autowired
    private ServiceScheduleFacade facade;

    @PostMapping
    public ServiceSchedule create(@RequestBody ServiceSchedule schedule) {
        return facade.create(schedule);
    }

    @PutMapping("/{id}/cancel")
    public void cancel(@PathVariable Long id) {
        facade.cancel(id);
    }

    @GetMapping("/user/{userId}")
    public List<ServiceSchedule> listByUser(@PathVariable Long userId) {
        return facade.listByUser(userId);
    }
}