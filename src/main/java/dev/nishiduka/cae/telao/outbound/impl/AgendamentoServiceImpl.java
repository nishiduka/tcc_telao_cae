package dev.nishiduka.cae.telao.outbound.impl;

import dev.nishiduka.cae.telao.core.domain.dtos.AgendamentoRecorrenteDTO;
import dev.nishiduka.cae.telao.core.repository.AgendamentoRecorrenteRepository;
import dev.nishiduka.cae.telao.outbound.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoServiceImpl implements AgendamentoService {

    @Autowired
    private AgendamentoRecorrenteRepository recorrenteRepository;

    public boolean validarConflitoAgenda(AgendamentoRecorrenteDTO agendamento) {
        return recorrenteRepository.validarConflitoAgenda(agendamento);
    }

    public boolean validarConflitoAgendaIgnorandoID(AgendamentoRecorrenteDTO agendamento) {
        return recorrenteRepository.validarConflitoAgendaIgnorandoID(agendamento);
    }
}
