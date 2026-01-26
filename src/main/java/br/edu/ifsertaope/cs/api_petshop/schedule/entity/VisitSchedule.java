package br.edu.ifsertaope.cs.api_petshop.schedule.entity;

import java.time.LocalDateTime;

import br.edu.ifsertaope.cs.api_petshop.user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "visit_schedules")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class VisitSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private String reason; // Ex: "Conhecer o hotelzinho", "Avaliação clínica"

    @Column(nullable = false)
    private LocalDateTime visitedAt;

    @Column(nullable = false)
    private Boolean confirmed = false;
}