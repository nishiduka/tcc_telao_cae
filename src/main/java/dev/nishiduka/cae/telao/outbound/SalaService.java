package dev.nishiduka.cae.telao.outbound;

import dev.nishiduka.cae.telao.core.domain.dtos.SalaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SalaService {
    public SalaDTO salvar(SalaDTO salaDTO);
    public List<SalaDTO> listarTodos();
    public SalaDTO filtrarPorId(Long id);
    public SalaDTO update(SalaDTO salaDTO, Long id);
    public void delete(Long id);
}
