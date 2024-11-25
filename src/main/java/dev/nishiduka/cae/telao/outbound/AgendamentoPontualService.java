package dev.nishiduka.cae.telao.outbound;

import dev.nishiduka.cae.telao.core.domain.dtos.AgendamentoPontualEntity;
import dev.nishiduka.cae.telao.core.domain.dtos.AgendamentoRecorrenteEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AgendamentoPontualService {
    public AgendamentoPontualEntity salvar(AgendamentoPontualEntity agendamentoDTO);
    public List<AgendamentoPontualEntity> listarTodos();
    public AgendamentoPontualEntity filtrarPorId(Long id);
    public AgendamentoPontualEntity update(AgendamentoPontualEntity agendamentoDTO, Long id);
    public void delete(Long id);
}
