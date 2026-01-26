package br.edu.ifsertaope.cs.api_petshop.schedule.command;

import br.edu.ifsertaope.cs.api_petshop.schedule.entity.VisitSchedule;
import br.edu.ifsertaope.cs.api_petshop.schedule.repository.VisitScheduleRepository;

public class CreateVisitScheduleCommand {
    private final VisitScheduleRepository repository;
    private final VisitSchedule visit;

    public CreateVisitScheduleCommand(VisitScheduleRepository repository, VisitSchedule visit) {
        this.repository = repository;
        this.visit = visit;
    }

    public VisitSchedule execute() {
        return repository.save(visit);
    }
}