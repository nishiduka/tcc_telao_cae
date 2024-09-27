package dev.nishiduka.cae.telao.inbound.impl;

import dev.nishiduka.cae.telao.core.domain.dtos.MateriaDTO;
import dev.nishiduka.cae.telao.core.domain.dtos.ResponseGenericDTO;
import dev.nishiduka.cae.telao.core.domain.exceptions.EntityNotFoundException;
import dev.nishiduka.cae.telao.inbound.MateriaController;
import dev.nishiduka.cae.telao.outbound.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/materias")
public class MateriaControllerImpl implements MateriaController {

    @Autowired
    private MateriaService Service;

    @GetMapping
    public ResponseEntity<? extends ResponseGenericDTO> listar() {
        return ResponseEntity.ok(
                new ResponseGenericDTO("Materia listado com sucesso", Service.listarTodos(), true)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<? extends ResponseGenericDTO> filtrarId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(
                    new ResponseGenericDTO("Materia encontrado com sucesso", Service.filtrarPorId(id), true)
            );
        } catch(EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(
                    new ResponseGenericDTO("Materia nao encontrado", null, false)
            );
        } catch(Exception ex) {
            return ResponseEntity.internalServerError().body(
                    new ResponseGenericDTO("Erro: " + ex.getMessage(), null, false)
            );
        }
    }

    @PostMapping
    public ResponseEntity<? extends ResponseGenericDTO> criar(@RequestBody MateriaDTO materiaDTO) {
        try {
            MateriaDTO curso = Service.salvar(materiaDTO);
            return ResponseEntity.ok(
                    new ResponseGenericDTO("Materia criado com sucesso", curso, true)
            );
        } catch(EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(
                    new ResponseGenericDTO("Materia nao encontrado", null, false)
            );
        } catch(Exception ex) {
            return ResponseEntity.internalServerError().body(
                    new ResponseGenericDTO("Erro: " + ex.getMessage(), null, false)
            );
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<? extends ResponseGenericDTO> update(@RequestBody MateriaDTO materiaDTO, @PathVariable Long id) {
        try {
            MateriaDTO curso = Service.update(materiaDTO, id);

            return ResponseEntity.ok(
                    new ResponseGenericDTO("Materia atualizado com sucesso", curso, true)
            );
        } catch(EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(
                    new ResponseGenericDTO("Materia nao encontrado", null, false)
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
            Service.delete(id);

            return ResponseEntity.ok(
                    new ResponseGenericDTO("Materia removido com sucesso", null, true)
            );
        } catch(EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(
                    new ResponseGenericDTO("Materia nao encontrado", null, false)
            );
        } catch(Exception ex) {
            return ResponseEntity.internalServerError().body(
                    new ResponseGenericDTO("Erro: " + ex.getMessage(), null, false)
            );
        }
    }
}
