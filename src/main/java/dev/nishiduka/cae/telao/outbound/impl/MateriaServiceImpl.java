package dev.nishiduka.cae.telao.outbound.impl;

import dev.nishiduka.cae.telao.core.domain.dtos.MateriaEntity;
import dev.nishiduka.cae.telao.core.domain.exceptions.EntityNotFoundException;
import dev.nishiduka.cae.telao.core.repository.MateriaRepository;
import dev.nishiduka.cae.telao.outbound.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaServiceImpl implements MateriaService {

    @Autowired
    private MateriaRepository repository;

    public List<MateriaEntity> listarTodos() {
        return repository.findAll();
    }

    public MateriaEntity filtrarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Materia nao encontrado"));
    }

    public MateriaEntity salvar(MateriaEntity cursoDTO) {
        return repository.save(cursoDTO);
    }

    public MateriaEntity update(MateriaEntity cursoDTO, Long id) {
        MateriaEntity curso = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Materia nao encontrado"));

        curso.setNome(cursoDTO.getNome());
        curso.setSigla(cursoDTO.getSigla());

        return salvar(curso);
    }

    public void delete(Long id) {
        MateriaEntity curso = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Materia nao encontrado"));

        repository.delete(curso);
    }
}
