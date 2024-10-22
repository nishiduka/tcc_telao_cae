package dev.nishiduka.cae.telao.inbound;

import dev.nishiduka.cae.telao.core.domain.dtos.requests.ResponseGenericDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface BlocoController {
    @GetMapping
    ResponseEntity<? extends ResponseGenericDTO> listar();
}
