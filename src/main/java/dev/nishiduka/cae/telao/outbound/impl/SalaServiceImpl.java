package dev.nishiduka.cae.telao.outbound.impl;

import dev.nishiduka.cae.telao.core.domain.dtos.BlocoEntity;
import dev.nishiduka.cae.telao.core.domain.dtos.SalaEntity;
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

    public List<SalaEntity> listarTodos() {
        return repository.findAll();
    }

    public SalaEntity filtrarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Curso nao encontrado"));
    }

    public SalaEntity salvar(SalaEntity salaEntity) {
        return repository.save(salaEntity);
    }

    public SalaEntity update(SalaEntity salaEntity, Long id) {
        SalaEntity salvo = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Curso nao encontrado"));

        salvo.setNome(salaEntity.getNome());
        salvo.setDescricao(salaEntity.getDescricao());
        salvo.setQtdComputadores(salaEntity.getQtdComputadores());
        salvo.setQtdAlunos(salaEntity.getQtdAlunos());

        BlocoEntity bloco = new BlocoEntity();
        bloco.setId(salaEntity.getBloco().getId());

        salvo.setBloco(bloco);

        return salvar(salvo);
    }

    public void delete(Long id) {
        SalaEntity salvo = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Curso nao encontrado"));

        repository.delete(salvo);
    }
}
