package br.edu.ifsertaope.cs.api_petshop.schedule.command;

import br.edu.ifsertaope.cs.api_petshop.schedule.entity.ServiceSchedule;
import br.edu.ifsertaope.cs.api_petshop.schedule.repository.ServiceScheduleRepository;

public class CancelServiceScheduleCommand {
    private final ServiceScheduleRepository repository;
    private final Long scheduleId;

    public CancelServiceScheduleCommand(ServiceScheduleRepository repository, Long scheduleId) {
        this.repository = repository;
        this.scheduleId = scheduleId;
    }

    public void execute() {
        ServiceSchedule schedule = repository.findById(scheduleId)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));
        schedule.setCanceled(true); 
        repository.save(schedule);
    }
}