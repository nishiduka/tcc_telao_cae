package dev.nishiduka.cae.telao.outbound;

import dev.nishiduka.cae.telao.core.domain.dtos.ProfessorDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfessorService {
    public ProfessorDTO salvar(ProfessorDTO professorDTO);
    public List<ProfessorDTO> listarTodos();
    public ProfessorDTO filtrarPorId(Long id);
    public ProfessorDTO update(ProfessorDTO professorDTO, Long id);
    public void delete(Long id);
}
