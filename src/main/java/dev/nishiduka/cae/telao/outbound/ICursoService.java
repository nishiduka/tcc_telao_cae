package dev.nishiduka.cae.telao.outbound;

import dev.nishiduka.cae.telao.core.domain.dtos.CursoDTO;

import java.util.List;

public interface ICursoService {
    public CursoDTO salvar(CursoDTO cursoDTO);
    public List<CursoDTO> listarTodos();
}
