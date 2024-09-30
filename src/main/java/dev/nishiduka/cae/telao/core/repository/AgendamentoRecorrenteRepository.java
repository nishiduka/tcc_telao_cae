package dev.nishiduka.cae.telao.core.repository;

import dev.nishiduka.cae.telao.core.domain.dtos.requests.AgendamentoRecorrenteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendamentoRecorrenteRepository extends JpaRepository<AgendamentoRecorrenteDTO, Long> {
    @Query("SELECT CASE WHEN COUNT (a) > 0 THEN true ELSE false END FROM AgendamentoRecorrenteDTO a WHERE a.diaSemana = :#{#agendamento.diaSemana} AND a.sala.id = :#{#agendamento.sala.id} AND ((a.horaInicio < :#{#agendamento.horaFim} AND a.horaFim > :#{#agendamento.horaInicio}))")
    boolean validarConflitoAgenda(AgendamentoRecorrenteDTO agendamento);

    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM AgendamentoRecorrenteDTO a WHERE a.diaSemana = :#{#agendamento.diaSemana} AND a.sala.id = :#{#agendamento.sala.id} AND ((a.horaInicio < :#{#agendamento.horaFim} AND a.horaFim > :#{#agendamento.horaInicio}))")
    boolean validarConflitoAgendaIgnorandoID(AgendamentoRecorrenteDTO agendamento);

    @Query("FROM AgendamentoRecorrenteDTO a WHERE a.id != :#{#agendamento.id} AND a.diaSemana = :#{#agendamento.diaSemana} AND a.sala.id = :#{#agendamento.sala.id} AND ((a.horaInicio < :#{#agendamento.horaFim} AND a.horaFim > :#{#agendamento.horaInicio}))")
    List<AgendamentoRecorrenteDTO> buscarAgendamentoPorSalaHorario(AgendamentoRecorrenteDTO agendamento);
}
