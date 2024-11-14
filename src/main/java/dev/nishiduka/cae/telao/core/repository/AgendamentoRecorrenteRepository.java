package dev.nishiduka.cae.telao.core.repository;

import dev.nishiduka.cae.telao.core.domain.dtos.AgendamentoRecorrenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendamentoRecorrenteRepository extends JpaRepository<AgendamentoRecorrenteEntity, Long> {
    @Query("SELECT CASE WHEN COUNT (a) > 0 THEN true ELSE false END FROM AgendamentoRecorrenteEntity a WHERE a.diaSemana = :#{#agendamento.diaSemana} AND a.sala.id = :#{#agendamento.sala.id} AND ((a.horaInicio < :#{#agendamento.horaFim} AND a.horaFim > :#{#agendamento.horaInicio}))")
    boolean validarConflitoAgenda(AgendamentoRecorrenteEntity agendamento);

    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM AgendamentoRecorrenteEntity a WHERE a.diaSemana = :#{#agendamento.diaSemana} AND a.sala.id = :#{#agendamento.sala.id} AND ((a.horaInicio < :#{#agendamento.horaFim} AND a.horaFim > :#{#agendamento.horaInicio}))")
    boolean validarConflitoAgendaIgnorandoID(AgendamentoRecorrenteEntity agendamento);

    @Query("FROM AgendamentoRecorrenteEntity a WHERE a.id != :#{#agendamento.id} AND a.diaSemana = :#{#agendamento.diaSemana} AND a.sala.id = :#{#agendamento.sala.id} AND ((a.horaInicio < :#{#agendamento.horaFim} AND a.horaFim > :#{#agendamento.horaInicio}))")
    List<AgendamentoRecorrenteEntity> buscarAgendamentoPorSalaHorario(AgendamentoRecorrenteEntity agendamento);

    @Query("FROM AgendamentoRecorrenteEntity a WHERE a.sala.id = :salaId")
    List<AgendamentoRecorrenteEntity> findBySalaId(@Param("salaId") Long salaId);
}
