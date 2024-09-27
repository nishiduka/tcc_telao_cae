package dev.nishiduka.cae.telao.core.repository;

import dev.nishiduka.cae.telao.core.domain.dtos.AgendamentoRecorrenteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRecorrenteRepository extends JpaRepository<AgendamentoRecorrenteDTO, Long> { }
