package dev.nishiduka.cae.telao.inbound.impl;

import dev.nishiduka.cae.telao.core.domain.dtos.requests.ResponseGenericDTO;
import dev.nishiduka.cae.telao.core.domain.dtos.ProfessorEntity;
import dev.nishiduka.cae.telao.core.domain.exceptions.EntityNotFoundException;
import dev.nishiduka.cae.telao.inbound.ProfessorController;
import dev.nishiduka.cae.telao.outbound.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/professores")
public class ProfessorControllerImpl implements ProfessorController {

    @Autowired
    private ProfessorService service;

    @GetMapping
    public ResponseEntity<? extends ResponseGenericDTO> listar() {
        return ResponseEntity.ok(
                new ResponseGenericDTO("Professor listado com sucesso", service.listarTodos(), true)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<? extends ResponseGenericDTO> filtrarId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(
                    new ResponseGenericDTO("Professor encontrado com sucesso", service.filtrarPorId(id), true)
            );
        } catch(EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(
                    new ResponseGenericDTO("Professor nao encontrado", null, false)
            );
        } catch(Exception ex) {
            return ResponseEntity.internalServerError().body(
                    new ResponseGenericDTO("Erro: " + ex.getMessage(), null, false)
            );
        }
    }

    @PostMapping
    public ResponseEntity<? extends ResponseGenericDTO> criar(@Valid @RequestBody ProfessorEntity professorEntity) {
        try {
            ProfessorEntity data = service.salvar(professorEntity);
            return ResponseEntity.ok(
                    new ResponseGenericDTO("Professor criado com sucesso", data, true)
            );
        } catch(EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(
                    new ResponseGenericDTO("Professor nao encontrado", null, false)
            );
        } catch(Exception ex) {
            return ResponseEntity.internalServerError().body(
                    new ResponseGenericDTO("Erro: " + ex.getMessage(), null, false)
            );
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<? extends ResponseGenericDTO> update(@Valid @RequestBody ProfessorEntity professorEntity, @PathVariable Long id) {
        try {
            ProfessorEntity data = service.update(professorEntity, id);

            return ResponseEntity.ok(
                    new ResponseGenericDTO("Professor atualizado com sucesso", data, true)
            );
        } catch(EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(
                    new ResponseGenericDTO("Professor nao encontrado", null, false)
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
                    new ResponseGenericDTO("Professor removido com sucesso", null, true)
            );
        } catch(EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(
                    new ResponseGenericDTO("Professor nao encontrado", null, false)
            );
        } catch(Exception ex) {
            return ResponseEntity.internalServerError().body(
                    new ResponseGenericDTO("Erro: " + ex.getMessage(), null, false)
            );
        }
    }
}
