package dev.nishiduka.cae.telao.outbound;

import dev.nishiduka.cae.telao.core.domain.dtos.AgendamentoRecorrenteEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AgendamentoRecorrenteService {
    public AgendamentoRecorrenteEntity salvar(AgendamentoRecorrenteEntity agendamentoDTO);
    public List<AgendamentoRecorrenteEntity> listarTodos();
    public AgendamentoRecorrenteEntity filtrarPorId(Long id);
    public AgendamentoRecorrenteEntity update(AgendamentoRecorrenteEntity agendamentoDTO, Long id);
    public void delete(Long id);
}
