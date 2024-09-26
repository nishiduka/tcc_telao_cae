package dev.nishiduka.cae.telao.outbound.impl;

import dev.nishiduka.cae.telao.core.domain.dtos.ProfessorDTO;
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

    public List<ProfessorDTO> listarTodos() {
        return repository.findAll();
    }

    public ProfessorDTO filtrarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Professor nao encontrado"));
    }

    public ProfessorDTO salvar(ProfessorDTO professorDTO) {
        return repository.save(professorDTO);
    }

    public ProfessorDTO update(ProfessorDTO professorDTO, Long id) {
        ProfessorDTO salvo = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Professor nao encontrado"));

        salvo.setNome(professorDTO.getNome());

        return salvar(salvo);
    }

    public void delete(Long id) {
        ProfessorDTO salvo = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Professor nao encontrado"));

        repository.delete(salvo);
    }
}
