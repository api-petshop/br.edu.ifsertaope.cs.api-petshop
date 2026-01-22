package br.edu.ifsertaope.cs.api_petshop.schedule.command;

import java.util.List;

import br.edu.ifsertaope.cs.api_petshop.schedule.entity.ServiceSchedule;
import br.edu.ifsertaope.cs.api_petshop.schedule.repository.ServiceScheduleRepository;

public class ListServiceSchedulesByUserCommand {
    private final ServiceScheduleRepository repository;
    private final Long userId;

    public ListServiceSchedulesByUserCommand(ServiceScheduleRepository repository, Long userId) {
        this.repository = repository;
        this.userId = userId;
    }

    public List<ServiceSchedule> execute() {
        return repository.findByUserId(userId);
    }
}