package dev.nishiduka.cae.telao.outbound.impl;

import dev.nishiduka.cae.telao.core.domain.dtos.SalaDTO;
import dev.nishiduka.cae.telao.core.domain.exceptions.EntityNotFoundException;
import dev.nishiduka.cae.telao.core.repository.SalaRepository;
import dev.nishiduka.cae.telao.outbound.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaServiceImpl implements SalaService {

    @Autowired
    private SalaRepository repository;

    public List<SalaDTO> listarTodos() {
        return repository.findAll();
    }

    public SalaDTO filtrarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Curso nao encontrado"));
    }

    public SalaDTO salvar(SalaDTO salaDTO) {
        return repository.save(salaDTO);
    }

    public SalaDTO update(SalaDTO salaDTO, Long id) {
        SalaDTO salvo = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Curso nao encontrado"));

        salvo.setNome(salaDTO.getNome());
        salvo.setDescricao(salaDTO.getDescricao());
        salvo.setQtdComputadores(salaDTO.getQtdComputadores());
        salvo.setQtdAlunos(salaDTO.getQtdAlunos());

        return salvar(salvo);
    }

    public void delete(Long id) {
        SalaDTO salvo = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Curso nao encontrado"));

        repository.delete(salvo);
    }
}
