package dev.nishiduka.cae.telao.inbound.impl;

import dev.nishiduka.cae.telao.core.domain.dtos.ResponseGenericDTO;
import dev.nishiduka.cae.telao.core.domain.dtos.AgendamentoRecorrenteDTO;
import dev.nishiduka.cae.telao.core.domain.exceptions.EntityNotFoundException;
import dev.nishiduka.cae.telao.inbound.AgendamentoRecorrenteController;
import dev.nishiduka.cae.telao.outbound.AgendamentoRecorrenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agendamentos-recorrentes")
public class AgendamentoRecorrenteControllerImpl implements AgendamentoRecorrenteController {

    @Autowired
    private AgendamentoRecorrenteService service;

    @GetMapping
    public ResponseEntity<? extends ResponseGenericDTO> listar() {
        return ResponseEntity.ok(
                new ResponseGenericDTO("Agendamento listado com sucesso", service.listarTodos(), true)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<? extends ResponseGenericDTO> filtrarId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(
                    new ResponseGenericDTO("Agendamento encontrado com sucesso", service.filtrarPorId(id), true)
            );
        } catch(EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(
                    new ResponseGenericDTO("Agendamento nao encontrado", null, false)
            );
        } catch(Exception ex) {
            return ResponseEntity.internalServerError().body(
                    new ResponseGenericDTO("Erro: " + ex.getMessage(), null, false)
            );
        }
    }

    @PostMapping
    public ResponseEntity<? extends ResponseGenericDTO> criar(@RequestBody AgendamentoRecorrenteDTO agendamento) {
        try {
            AgendamentoRecorrenteDTO curso = service.salvar(agendamento);
            return ResponseEntity.ok(
                    new ResponseGenericDTO("Agendamento criado com sucesso", curso, true)
            );
        } catch(EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(
                    new ResponseGenericDTO("Agendamento nao encontrado", null, false)
            );
        } catch(Exception ex) {
            return ResponseEntity.internalServerError().body(
                    new ResponseGenericDTO("Erro: " + ex.getMessage(), null, false)
            );
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<? extends ResponseGenericDTO> update(@RequestBody AgendamentoRecorrenteDTO agendamento, @PathVariable Long id) {
        try {
            AgendamentoRecorrenteDTO curso = service.update(agendamento, id);

            return ResponseEntity.ok(
                    new ResponseGenericDTO("Agendamento atualizado com sucesso", curso, true)
            );
        } catch(EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(
                    new ResponseGenericDTO("Agendamento nao encontrado", null, false)
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
                    new ResponseGenericDTO("Agendamento removido com sucesso", null, true)
            );
        } catch(EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(
                    new ResponseGenericDTO("Agendamento nao encontrado", null, false)
            );
        } catch(Exception ex) {
            return ResponseEntity.internalServerError().body(
                    new ResponseGenericDTO("Erro: " + ex.getMessage(), null, false)
            );
        }
    }
}
