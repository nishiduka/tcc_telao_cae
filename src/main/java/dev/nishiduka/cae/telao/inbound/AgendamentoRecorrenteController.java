package dev.nishiduka.cae.telao.inbound;

import dev.nishiduka.cae.telao.core.domain.dtos.requests.ResponseGenericDTO;
import dev.nishiduka.cae.telao.core.domain.dtos.AgendamentoRecorrenteEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface AgendamentoRecorrenteController {
    @GetMapping
    public ResponseEntity<? extends ResponseGenericDTO> listar();

    @GetMapping("/{id}")
    public ResponseEntity<? extends ResponseGenericDTO> filtrarId(@PathVariable Long id);

    @PostMapping
    public ResponseEntity<? extends ResponseGenericDTO> criar(@RequestBody AgendamentoRecorrenteEntity agendamentoDTO);

    @PutMapping("/{id}")
    public ResponseEntity<? extends ResponseGenericDTO> update(@RequestBody AgendamentoRecorrenteEntity agendamentoDTO, @PathVariable Long id);

    @DeleteMapping("/{id}")
    public ResponseEntity<? extends ResponseGenericDTO> delete(@PathVariable Long id);
}
