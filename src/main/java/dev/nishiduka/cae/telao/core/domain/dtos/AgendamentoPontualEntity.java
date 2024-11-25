package dev.nishiduka.cae.telao.core.domain.dtos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "agendamento_pontual")
public class AgendamentoPontualEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private ProfessorEntity professor;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "materia_id")
    private MateriaEntity materia;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "sala_id")
    private SalaEntity sala;

    @NotNull
    @Column(name = "data", nullable = false)
    private LocalDateTime data;

    @NotNull
    @Column(name = "horario_inicio", nullable = false, length = 5)
    private String horarioInicio;

    @NotNull
    @Column(name = "horario_fim", nullable = false, length = 45)
    private String horarioFim;

    @CreationTimestamp
    @Column(name = "created_at", nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    public AgendamentoPontualEntity(AgendamentoDTO agendamento, LocalDateTime data) {
        this.id = agendamento.getId();
        this.sala = agendamento.getSala();
        this.professor = agendamento.getProfessor();
        this.materia = agendamento.getMateria();
        this.data = data;
        this.horarioInicio = agendamento.getHorarioInicio();
        this.horarioFim = agendamento.getHorarioFim();
    }
}
