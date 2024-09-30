package dev.nishiduka.cae.telao.outbound;

import dev.nishiduka.cae.telao.core.domain.dtos.SalaEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SalaService {
    public SalaEntity salvar(SalaEntity salaEntity);
    public List<SalaEntity> listarTodos();
    public SalaEntity filtrarPorId(Long id);
    public SalaEntity update(SalaEntity salaEntity, Long id);
    public void delete(Long id);
}
