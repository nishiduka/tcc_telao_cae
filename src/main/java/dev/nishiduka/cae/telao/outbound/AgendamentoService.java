package dev.nishiduka.cae.telao.outbound;

import dev.nishiduka.cae.telao.core.domain.dtos.AgendamentoRecorrenteDTO;
import org.springframework.stereotype.Service;

@Service
public interface AgendamentoService {

    boolean validarConflitoAgenda(AgendamentoRecorrenteDTO agendamento);
    boolean validarConflitoAgendaIgnorandoID(AgendamentoRecorrenteDTO agendamento);
}
