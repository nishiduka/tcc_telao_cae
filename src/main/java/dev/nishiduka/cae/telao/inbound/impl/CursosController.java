package dev.nishiduka.cae.telao.inbound.impl;

import dev.nishiduka.cae.telao.core.domain.dtos.CursoDTO;
import dev.nishiduka.cae.telao.core.domain.dtos.ResponseGenericDTO;
import dev.nishiduka.cae.telao.core.domain.exceptions.EntityNotFoundException;
import dev.nishiduka.cae.telao.inbound.ICursosController;
import dev.nishiduka.cae.telao.outbound.ICursoService;
import dev.nishiduka.cae.telao.outbound.impl.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursosController implements ICursosController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<? extends ResponseGenericDTO> listarCursos() {
        return ResponseEntity.ok(
                new ResponseGenericDTO("Curso criado com sucesso", cursoService.listarTodos(), true)
        );
    }

    @PostMapping
    public ResponseEntity<? extends ResponseGenericDTO> criarCurso(@RequestBody CursoDTO cursoDTO) {
        try {
            CursoDTO curso = cursoService.salvar(cursoDTO);
            return ResponseEntity.ok(
                    new ResponseGenericDTO("Curso criado com sucesso", curso, true)
            );
        } catch(EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(
                    new ResponseGenericDTO("Curso nao encontrado", null, false)
            );
        } catch(Exception ex) {
            return ResponseEntity.internalServerError().body(
                    new ResponseGenericDTO("Erro: " + ex.getMessage(), null, false)
            );
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<? extends ResponseGenericDTO> updateCurso(@RequestBody CursoDTO cursoDTO, @PathVariable Long id) {
        try {
            CursoDTO curso = cursoService.update(cursoDTO, id);

            return ResponseEntity.ok(
                    new ResponseGenericDTO("Curso atualizado com sucesso", curso, true)
            );
        } catch(EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(
                    new ResponseGenericDTO("Curso nao encontrado", null, false)
            );
        } catch(Exception ex) {
            return ResponseEntity.internalServerError().body(
                    new ResponseGenericDTO("Erro: " + ex.getMessage(), null, false)
            );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<? extends ResponseGenericDTO> deleteCurso(@PathVariable Long id) {
        try {
            cursoService.delete(id);

            return ResponseEntity.ok(
                    new ResponseGenericDTO("Curso removido com sucesso", null, true)
            );
        } catch(EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(
                    new ResponseGenericDTO("Curso nao encontrado", null, false)
            );
        } catch(Exception ex) {
            return ResponseEntity.internalServerError().body(
                    new ResponseGenericDTO("Erro: " + ex.getMessage(), null, false)
            );
        }
    }
}
