package br.edu.ifsertaope.cs.api_petshop.schedule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsertaope.cs.api_petshop.schedule.entity.VisitSchedule;

public interface VisitScheduleRepository extends JpaRepository<VisitSchedule, Long> {
    List<VisitSchedule> findByUserId(Long userId);
}