package dev.nishiduka.cae.telao.outbound;

import dev.nishiduka.cae.telao.core.domain.dtos.MateriaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MateriaService {
    public MateriaDTO salvar(MateriaDTO materiaDTO);
    public List<MateriaDTO> listarTodos();
    public MateriaDTO filtrarPorId(Long id);
    public MateriaDTO update(MateriaDTO materiaDTO, Long id);
    public void delete(Long id);
}
