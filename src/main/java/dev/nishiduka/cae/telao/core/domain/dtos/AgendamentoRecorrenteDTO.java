package dev.nishiduka.cae.telao.core.domain.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "agendamento_recorrente")
public class AgendamentoRecorrenteDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "dia_semana")
    private EDiaSemana diaSemana;

    @Column(name = "horario_inicio")
    private String horaInicio;

    @Column(name = "horario_fim")
    private String horaFim;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private ProfessorDTO professor;

    @ManyToOne
    @JoinColumn(name = "materia_id")
    private MateriaDTO materia;

    @ManyToOne
    @JoinColumn(name = "sala_id")
    private SalaDTO sala;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
