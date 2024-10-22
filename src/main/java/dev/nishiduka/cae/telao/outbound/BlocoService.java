package dev.nishiduka.cae.telao.outbound;

import dev.nishiduka.cae.telao.core.domain.dtos.BlocoEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlocoService {
    public List<BlocoEntity> listarTodos();
}
