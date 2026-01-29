package br.edu.ifsertaope.cs.api_petshop.schedule.controller; // O package agora é schedule

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsertaope.cs.api_petshop.schedule.entity.VisitSchedule;
import br.edu.ifsertaope.cs.api_petshop.schedule.facade.VisitScheduleFacade;

@RestController
@RequestMapping("/visit-schedules")
public class VisitScheduleController {

    @Autowired
    private VisitScheduleFacade facade;

    @PostMapping
    public VisitSchedule create(@RequestBody VisitSchedule visit) {
        return facade.createVisit(visit);
    }

    @GetMapping("/user/{userId}")
    public List<VisitSchedule> listByUser(@PathVariable Long userId) {
        return facade.listByUser(userId);
    }
}