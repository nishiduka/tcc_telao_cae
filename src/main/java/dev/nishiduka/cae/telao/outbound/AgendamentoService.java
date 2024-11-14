package dev.nishiduka.cae.telao.outbound;

import dev.nishiduka.cae.telao.core.domain.dtos.AgendamentoDTO;
import dev.nishiduka.cae.telao.core.domain.dtos.AgendamentoRecorrenteEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AgendamentoService {
    List<AgendamentoDTO> listarAgendamentosSemana(int semana);

    List<AgendamentoDTO> listarAgendamentosSalaSemana(Long salaId, int semana);
}
