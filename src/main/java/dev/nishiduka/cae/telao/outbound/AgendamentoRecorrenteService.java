package dev.nishiduka.cae.telao.outbound;

import dev.nishiduka.cae.telao.core.domain.dtos.requests.AgendamentoRecorrenteDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AgendamentoRecorrenteService {
    public AgendamentoRecorrenteDTO salvar(AgendamentoRecorrenteDTO agendamentoDTO);
    public List<AgendamentoRecorrenteDTO> listarTodos();
    public AgendamentoRecorrenteDTO filtrarPorId(Long id);
    public AgendamentoRecorrenteDTO update(AgendamentoRecorrenteDTO agendamentoDTO, Long id);
    public void delete(Long id);
}
