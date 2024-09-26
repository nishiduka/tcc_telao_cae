package dev.nishiduka.cae.telao.inbound;

import dev.nishiduka.cae.telao.core.domain.dtos.ProfessorDTO;
import dev.nishiduka.cae.telao.core.domain.dtos.ResponseGenericDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface ProfessorController {
    @GetMapping
    public ResponseEntity<? extends ResponseGenericDTO> listar();

    @GetMapping("/{id}")
    public ResponseEntity<? extends ResponseGenericDTO> filtrarId(@PathVariable Long id);

    @PostMapping
    public ResponseEntity<? extends ResponseGenericDTO> criar(@RequestBody ProfessorDTO professorDTO);

    @PutMapping("/{id}")
    public ResponseEntity<? extends ResponseGenericDTO> update(@RequestBody ProfessorDTO professorDTO, @PathVariable Long id);

    @DeleteMapping("/{id}")
    public ResponseEntity<? extends ResponseGenericDTO> delete(@PathVariable Long id);
}