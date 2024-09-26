package dev.nishiduka.cae.telao.outbound.impl;

import dev.nishiduka.cae.telao.core.domain.dtos.MateriaDTO;
import dev.nishiduka.cae.telao.core.domain.exceptions.EntityNotFoundException;
import dev.nishiduka.cae.telao.core.repository.MateriaRepository;
import dev.nishiduka.cae.telao.outbound.MateriaService;
import dev.nishiduka.cae.telao.outbound.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaServiceImpl implements MateriaService {

    @Autowired
    private MateriaRepository repository;

    public List<MateriaDTO> listarTodos() {
        return repository.findAll();
    }

    public MateriaDTO filtrarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Materia nao encontrado"));
    }

    public MateriaDTO salvar(MateriaDTO cursoDTO) {
        return repository.save(cursoDTO);
    }

    public MateriaDTO update(MateriaDTO cursoDTO, Long id) {
        MateriaDTO curso = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Materia nao encontrado"));

        curso.setNome(cursoDTO.getNome());
        curso.setSigla(cursoDTO.getSigla());

        return salvar(curso);
    }

    public void delete(Long id) {
        MateriaDTO curso = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Materia nao encontrado"));

        repository.delete(curso);
    }
}
