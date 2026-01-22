package br.edu.ifsertaope.cs.api_petshop.schedule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsertaope.cs.api_petshop.schedule.entity.ServiceSchedule;

public interface ServiceScheduleRepository extends JpaRepository<ServiceSchedule, Long> {
    List<ServiceSchedule> findByUserId(Long userId);
}