package dev.nishiduka.cae.telao.outbound;

import dev.nishiduka.cae.telao.core.domain.dtos.CursoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CursoService {
    public CursoDTO salvar(CursoDTO cursoDTO);
    public List<CursoDTO> listarTodos();
    public CursoDTO filtrarPorId(Long id);
    public CursoDTO update(CursoDTO cursoDTO, Long id);
    public void delete(Long id);
}
