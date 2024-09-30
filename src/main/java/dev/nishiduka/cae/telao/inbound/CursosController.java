package dev.nishiduka.cae.telao.inbound;

import dev.nishiduka.cae.telao.core.domain.dtos.CursoEntity;
import dev.nishiduka.cae.telao.core.domain.dtos.requests.ResponseGenericDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface CursosController {
    @GetMapping
    public ResponseEntity<? extends ResponseGenericDTO> listar();

    @GetMapping("/{id}")
    public ResponseEntity<? extends ResponseGenericDTO> filtrarId(@PathVariable Long id);

    @PostMapping
    public ResponseEntity<? extends ResponseGenericDTO> criar(@RequestBody CursoEntity cursoEntity);

    @PutMapping("/{id}")
    public ResponseEntity<? extends ResponseGenericDTO> update(@RequestBody CursoEntity cursoEntity, @PathVariable Long id);

    @DeleteMapping("/{id}")
    public ResponseEntity<? extends ResponseGenericDTO> delete(@PathVariable Long id);
}
