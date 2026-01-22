package br.edu.ifsertaope.cs.api_petshop.schedule.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsertaope.cs.api_petshop.schedule.command.CancelServiceScheduleCommand;
import br.edu.ifsertaope.cs.api_petshop.schedule.command.CreateServiceScheduleCommand;
import br.edu.ifsertaope.cs.api_petshop.schedule.command.ListServiceSchedulesByUserCommand;
import br.edu.ifsertaope.cs.api_petshop.schedule.entity.ServiceSchedule;
import br.edu.ifsertaope.cs.api_petshop.schedule.repository.ServiceScheduleRepository;

@Service
public class ServiceScheduleFacade {

    @Autowired
    private ServiceScheduleRepository repository;

    public ServiceSchedule create(ServiceSchedule schedule) {
        return new CreateServiceScheduleCommand(repository, schedule).execute();
    }

    public void cancel(Long id) {
        new CancelServiceScheduleCommand(repository, id).execute();
    }

    public List<ServiceSchedule> listByUser(Long userId) {
        return new ListServiceSchedulesByUserCommand(repository, userId).execute();
    }
}