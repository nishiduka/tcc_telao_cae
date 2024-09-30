package dev.nishiduka.cae.telao.outbound;

import dev.nishiduka.cae.telao.core.domain.dtos.ProfessorEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfessorService {
    public ProfessorEntity salvar(ProfessorEntity professorEntity);
    public List<ProfessorEntity> listarTodos();
    public ProfessorEntity filtrarPorId(Long id);
    public ProfessorEntity update(ProfessorEntity professorEntity, Long id);
    public void delete(Long id);
}
