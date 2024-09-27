package dev.nishiduka.cae.telao.outbound.impl;

import dev.nishiduka.cae.telao.core.domain.dtos.AgendamentoRecorrenteDTO;
import dev.nishiduka.cae.telao.core.domain.exceptions.EntityNotFoundException;
import dev.nishiduka.cae.telao.core.repository.AgendamentoRecorrenteRepository;
import dev.nishiduka.cae.telao.outbound.AgendamentoRecorrenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoRecorrenteServiceImpl implements AgendamentoRecorrenteService {

    @Autowired
    private AgendamentoRecorrenteRepository repository;

    public List<AgendamentoRecorrenteDTO> listarTodos() {
        return repository.findAll();
    }

    public AgendamentoRecorrenteDTO filtrarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Agendamento recorrente nao encontrado"));
    }

    public AgendamentoRecorrenteDTO salvar(AgendamentoRecorrenteDTO agendamento) {
        return repository.save(agendamento);
    }

    public AgendamentoRecorrenteDTO update(AgendamentoRecorrenteDTO agendamento, Long id) {
        AgendamentoRecorrenteDTO salvo = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Agendamento recorrente nao encontrado"));

        salvo.setMateria(agendamento.getMateria());
        salvo.setProfessor(agendamento.getProfessor());
        salvo.setSala(agendamento.getSala());
        salvo.setDiaSemana(agendamento.getDiaSemana());
        salvo.setHoraInicio(agendamento.getHoraInicio());
        salvo.setHoraFim(agendamento.getHoraFim());

        return salvar(salvo);
    }

    public void delete(Long id) {
        AgendamentoRecorrenteDTO salvo = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Agendamento recorrente nao encontrado"));

        repository.delete(salvo);
    }
}
