package dev.nishiduka.cae.telao.outbound;

import dev.nishiduka.cae.telao.core.domain.dtos.CursoEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CursoService {
    public CursoEntity salvar(CursoEntity cursoEntity);
    public List<CursoEntity> listarTodos();
    public CursoEntity filtrarPorId(Long id);
    public CursoEntity update(CursoEntity cursoEntity, Long id);
    public void delete(Long id);
}
