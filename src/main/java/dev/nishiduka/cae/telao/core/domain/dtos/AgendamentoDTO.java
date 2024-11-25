package dev.nishiduka.cae.telao.core.domain.dtos;

import dev.nishiduka.cae.telao.core.domain.dtos.*;
import dev.nishiduka.cae.telao.core.domain.enums.EDiaSemana;
import dev.nishiduka.cae.telao.core.domain.enums.ETipoAgendamento;
import lombok.*;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AgendamentoDTO {
    private Long id;
    private SalaEntity sala;
    private ProfessorEntity professor;
    private MateriaEntity materia;
    private EDiaSemana diaSemana;
    private ETipoAgendamento tipo;
    private String horarioInicio;
    private String horarioFim;

    public AgendamentoDTO(AgendamentoRecorrenteEntity recorrente) {
        this.id = recorrente.getId();
        this.sala = recorrente.getSala();
        this.professor = recorrente.getProfessor();
        this.materia = recorrente.getMateria();
        this.diaSemana = recorrente.getDiaSemana();
        this.horarioInicio = recorrente.getHoraInicio();
        this.horarioFim = recorrente.getHoraFim();

        this.tipo = ETipoAgendamento.RECORRENTE;
    }
    
    public AgendamentoDTO(AgendamentoPontualEntity pontual) {
        this.id = pontual.getId();
        this.sala = pontual.getSala();
        this.professor = pontual.getProfessor();
        this.materia = pontual.getMateria();
        this.diaSemana = EDiaSemana.fromLocalDateTime(pontual.getData());
        this.horarioInicio = pontual.getHorarioInicio();
        this.horarioFim = pontual.getHorarioFim();

        this.tipo = ETipoAgendamento.PONTUAL;
    }

    @Override
    public String toString() {
        return "Agendamento[" +
                "id=" + id +
                ", sala=" + (sala != null ? sala.getId() : "null") +
                ", professor=" + (professor != null ? professor.getNome() : "null") +
                ", materia=" + (materia != null ? materia.getNome() : "null") +
                ", diaSemana=" + (diaSemana != null ? diaSemana.name() : "null") +
                ", tipo=" + (tipo != null ? tipo.name() : "null") +
                ", horarioInicio='" + horarioInicio + '\'' +
                ", horarioFim='" + horarioFim + '\'' +
                ']';
    }
}
