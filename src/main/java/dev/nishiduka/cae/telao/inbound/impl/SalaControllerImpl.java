package dev.nishiduka.cae.telao.inbound.impl;

import dev.nishiduka.cae.telao.core.domain.dtos.SalaEntity;
import dev.nishiduka.cae.telao.core.domain.dtos.requests.ResponseGenericDTO;
import dev.nishiduka.cae.telao.core.domain.exceptions.EntityNotFoundException;
import dev.nishiduka.cae.telao.inbound.SalaController;
import dev.nishiduka.cae.telao.outbound.SalaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/salas")
public class SalaControllerImpl implements SalaController {

    @Autowired
    private SalaService service;

    @GetMapping
    public ResponseEntity<? extends ResponseGenericDTO> listar() {
        return ResponseEntity.ok(
                new ResponseGenericDTO("Sala listado com sucesso", service.listarTodos(), true)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<? extends ResponseGenericDTO> filtrarId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(
                    new ResponseGenericDTO("Sala encontrado com sucesso", service.filtrarPorId(id), true)
            );
        } catch(EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(
                    new ResponseGenericDTO("Sala nao encontrado", null, false)
            );
        } catch(Exception ex) {
            return ResponseEntity.internalServerError().body(
                    new ResponseGenericDTO("Erro: " + ex.getMessage(), null, false)
            );
        }
    }

    @PostMapping
    public ResponseEntity<? extends ResponseGenericDTO> criar(@Valid @RequestBody SalaEntity salaEntity) {
        try {
            SalaEntity curso = service.salvar(salaEntity);
            return ResponseEntity.ok(
                    new ResponseGenericDTO("Sala criado com sucesso", curso, true)
            );
        } catch(EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(
                    new ResponseGenericDTO("Sala nao encontrado", null, false)
            );
        } catch(Exception ex) {
            return ResponseEntity.internalServerError().body(
                    new ResponseGenericDTO("Erro: " + ex.getMessage(), null, false)
            );
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<? extends ResponseGenericDTO> update(@Valid @RequestBody SalaEntity salaEntity, @PathVariable Long id) {
        try {
            SalaEntity curso = service.update(salaEntity, id);

            return ResponseEntity.ok(
                    new ResponseGenericDTO("Sala atualizado com sucesso", curso, true)
            );
        } catch(EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(
                    new ResponseGenericDTO("Sala nao encontrado", null, false)
            );
        } catch(Exception ex) {
            return ResponseEntity.internalServerError().body(
                    new ResponseGenericDTO("Erro: " + ex.getMessage(), null, false)
            );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<? extends ResponseGenericDTO> delete(@PathVariable Long id) {
        try {
            service.delete(id);

            return ResponseEntity.ok(
                    new ResponseGenericDTO("Sala removido com sucesso", null, true)
            );
        } catch(EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(
                    new ResponseGenericDTO("Sala nao encontrado", null, false)
            );
        } catch(Exception ex) {
            return ResponseEntity.internalServerError().body(
                    new ResponseGenericDTO("Erro: " + ex.getMessage(), null, false)
            );
        }
    }
}
