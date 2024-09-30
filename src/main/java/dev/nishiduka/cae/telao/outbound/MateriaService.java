package dev.nishiduka.cae.telao.outbound;

import dev.nishiduka.cae.telao.core.domain.dtos.MateriaEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MateriaService {
    public MateriaEntity salvar(MateriaEntity materiaEntity);
    public List<MateriaEntity> listarTodos();
    public MateriaEntity filtrarPorId(Long id);
    public MateriaEntity update(MateriaEntity materiaEntity, Long id);
    public void delete(Long id);
}
