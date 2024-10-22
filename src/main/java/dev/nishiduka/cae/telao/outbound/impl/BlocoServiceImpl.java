package dev.nishiduka.cae.telao.outbound.impl;

import dev.nishiduka.cae.telao.core.domain.dtos.BlocoEntity;
import dev.nishiduka.cae.telao.core.repository.BlocoRepository;
import dev.nishiduka.cae.telao.outbound.BlocoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BlocoServiceImpl implements BlocoService {
    @Autowired
    private BlocoRepository repository;

    @Override
    public List<BlocoEntity> listarTodos() {
        return repository.findAll();
    }
}
