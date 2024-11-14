package dev.nishiduka.cae.telao.outbound.impl;

import dev.nishiduka.cae.telao.core.domain.dtos.AgendamentoPontualEntity;
import dev.nishiduka.cae.telao.core.domain.exceptions.EntityAlreadyExistsException;
import dev.nishiduka.cae.telao.core.domain.exceptions.EntityNotFoundException;
import dev.nishiduka.cae.telao.core.repository.AgendamentoPontualRepository;
import dev.nishiduka.cae.telao.outbound.AgendamentoPontualService;
import dev.nishiduka.cae.telao.outbound.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoPontualServiceImpl implements AgendamentoPontualService {

    @Autowired
    private AgendamentoPontualRepository repository;

    @Autowired
    private AgendamentoService agendamentoService;

    public List<AgendamentoPontualEntity> listarTodos() {
        return repository.findAll();
    }

    public AgendamentoPontualEntity filtrarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Agendamento recorrente nao encontrado"));
    }

    public AgendamentoPontualEntity salvar(AgendamentoPontualEntity agendamento) {
        boolean possuiConflito = repository.buscarAgendamentoPorSalaHorario(agendamento).size() > 0;

        if(possuiConflito) {
            throw new EntityAlreadyExistsException("Conflito de horario");
        }

        return repository.save(agendamento);
    }

    public AgendamentoPontualEntity update(AgendamentoPontualEntity agendamento, Long id) {
        AgendamentoPontualEntity salvo = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Agendamento recorrente nao encontrado"));

        if(repository.validarConflitoAgendaIgnorandoID(salvo)) {
            throw new EntityAlreadyExistsException("Conflito de horario");
        }

        salvo.setMateria(agendamento.getMateria());
        salvo.setProfessor(agendamento.getProfessor());
        salvo.setSala(agendamento.getSala());
        salvo.setData(agendamento.getData());

        salvo.setHorarioInicio(agendamento.getHorarioInicio());
        salvo.setHorarioFim(agendamento.getHorarioFim());

        return repository.save(salvo);
    }

    public void delete(Long id) {
        AgendamentoPontualEntity salvo = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Agendamento recorrente nao encontrado"));

        repository.delete(salvo);
    }
}
