package br.edu.ifsertaope.cs.api_petshop.schedule.command;

import br.edu.ifsertaope.cs.api_petshop.schedule.entity.ServiceSchedule;
import br.edu.ifsertaope.cs.api_petshop.schedule.repository.ServiceScheduleRepository;

public class CreateServiceScheduleCommand {
    private final ServiceScheduleRepository repository;
    private final ServiceSchedule schedule;

    public CreateServiceScheduleCommand(ServiceScheduleRepository repository, ServiceSchedule schedule) {
        this.repository = repository;
        this.schedule = schedule;
    }

    public ServiceSchedule execute() {
        return repository.save(schedule);
    }
}
