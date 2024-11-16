package dev.nishiduka.cae.telao.core.repository;

import dev.nishiduka.cae.telao.core.domain.dtos.AgendamentoPontualEntity;
import dev.nishiduka.cae.telao.core.domain.dtos.AgendamentoRecorrenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendamentoPontualRepository extends JpaRepository<AgendamentoPontualEntity, Long> {
    List<AgendamentoPontualEntity> findBySalaId(Long salaId);

    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END " +
            "FROM AgendamentoPontualEntity a " +
            "WHERE a.id != :#{#agendamento.id} " +
            "AND a.data = :#{#agendamento.data} " +
            "AND a.sala.id = :#{#agendamento.sala.id} " +
            "AND (a.horarioInicio < :#{#agendamento.horarioFim} " +
            "AND a.horarioFim > :#{#agendamento.horarioInicio})")
    boolean validarConflitoAgendaIgnorandoID(AgendamentoPontualEntity agendamento);

    @Query("FROM AgendamentoPontualEntity a " +
            "WHERE  a.data = :#{#agendamento.data}  " +
            "AND a.sala.id = :#{#agendamento.sala.id} " +
            "AND (a.horarioInicio < :#{#agendamento.horarioFim} " +
            "AND a.horarioFim > :#{#agendamento.horarioInicio})")
    List<AgendamentoPontualEntity> buscarAgendamentoPorSalaHorario(AgendamentoPontualEntity agendamento);

    @Query(value = "SELECT * FROM agendamento_pontual e WHERE WEEK(e.data) = :semana AND e.sala_id = :id", nativeQuery = true)
    List<AgendamentoPontualEntity> findBySalaIdAndSemana(Long id, int semana);

    @Query("FROM AgendamentoPontualEntity e WHERE WEEK(e.data) = :semana")
    List<AgendamentoPontualEntity> findBySemana(int semana);
}
