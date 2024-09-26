package dev.nishiduka.cae.telao.outbound.impl;

import dev.nishiduka.cae.telao.core.domain.dtos.CursoDTO;
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

    public List<CursoDTO> listarTodos() {
        return cursoRepository.findAll();
    }

    public CursoDTO filtrarPorId(Long id) {
        return cursoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Curso nao encontrado"));
    }

    public CursoDTO salvar(CursoDTO cursoDTO) {
        return cursoRepository.save(cursoDTO);
    }

    public CursoDTO update(CursoDTO cursoDTO, Long id) {
        CursoDTO curso = cursoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Curso nao encontrado"));

        curso.setNome(cursoDTO.getNome());
        curso.setSigla(cursoDTO.getSigla());

        return salvar(curso);
    }

    public void delete(Long id) {
        CursoDTO curso = cursoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Curso nao encontrado"));

        cursoRepository.delete(curso);
    }
}
