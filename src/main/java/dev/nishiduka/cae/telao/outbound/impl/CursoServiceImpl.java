package dev.nishiduka.cae.telao.outbound.impl;

import dev.nishiduka.cae.telao.core.domain.dtos.CursoEntity;
import dev.nishiduka.cae.telao.core.domain.exceptions.EntityNotFoundException;
import dev.nishiduka.cae.telao.core.repository.CursoRepository;
import dev.nishiduka.cae.telao.outbound.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<CursoEntity> listarTodos() {
        return cursoRepository.findAll();
    }

    public CursoEntity filtrarPorId(Long id) {
        return cursoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Curso nao encontrado"));
    }

    public CursoEntity salvar(CursoEntity cursoEntity) {
        return cursoRepository.save(cursoEntity);
    }

    public CursoEntity update(CursoEntity cursoEntity, Long id) {
        CursoEntity curso = cursoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Curso nao encontrado"));

        curso.setNome(cursoEntity.getNome());
        curso.setSigla(cursoEntity.getSigla());

        return salvar(curso);
    }

    public void delete(Long id) {
        CursoEntity curso = cursoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Curso nao encontrado"));

        cursoRepository.delete(curso);
    }
}
