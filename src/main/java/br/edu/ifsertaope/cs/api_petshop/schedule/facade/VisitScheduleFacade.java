package br.edu.ifsertaope.cs.api_petshop.schedule.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsertaope.cs.api_petshop.schedule.command.CreateVisitScheduleCommand;
import br.edu.ifsertaope.cs.api_petshop.schedule.entity.VisitSchedule;
import br.edu.ifsertaope.cs.api_petshop.schedule.repository.VisitScheduleRepository;

@Service
public class VisitScheduleFacade {

    @Autowired
    private VisitScheduleRepository repository;

    public VisitSchedule createVisit(VisitSchedule visit) {
        return new CreateVisitScheduleCommand(repository, visit).execute();
    }

    public List<VisitSchedule> listByUser(Long userId) {
        return repository.findByUserId(userId);
    }
}