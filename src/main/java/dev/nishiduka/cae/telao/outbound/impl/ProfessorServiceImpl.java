package dev.nishiduka.cae.telao.outbound.impl;

import dev.nishiduka.cae.telao.core.domain.dtos.ProfessorEntity;
import dev.nishiduka.cae.telao.core.domain.exceptions.EntityNotFoundException;
import dev.nishiduka.cae.telao.core.repository.ProfessorRepository;
import dev.nishiduka.cae.telao.outbound.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository repository;

    public List<ProfessorEntity> listarTodos() {
        return repository.findAll();
    }

    public ProfessorEntity filtrarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Professor nao encontrado"));
    }

    public ProfessorEntity salvar(ProfessorEntity professorEntity) {
        return repository.save(professorEntity);
    }

    public ProfessorEntity update(ProfessorEntity professorEntity, Long id) {
        ProfessorEntity salvo = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Professor nao encontrado"));

        salvo.setNome(professorEntity.getNome());

        return salvar(salvo);
    }

    public void delete(Long id) {
        ProfessorEntity salvo = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Professor nao encontrado"));

        repository.delete(salvo);
    }
}
