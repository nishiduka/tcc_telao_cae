package dev.nishiduka.cae.telao.inbound.impl;

import dev.nishiduka.cae.telao.core.domain.dtos.AgendamentoDTO;
import dev.nishiduka.cae.telao.core.domain.dtos.requests.ResponseGenericDTO;
import dev.nishiduka.cae.telao.inbound.AgendamentoController;
import dev.nishiduka.cae.telao.outbound.AgendamentoService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/api/agendamentos")
@Slf4j
public class AgendamentoControllerImpl implements AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping("/semana/{semana}")
    public ResponseEntity<? extends ResponseGenericDTO> listarAgendamentos(@PathVariable int semana) {
        try {
            List<AgendamentoDTO> listagem = agendamentoService.listarAgendamentosSemana(semana);
            return ResponseEntity.ok(
                    new ResponseGenericDTO("Listagem realizada com sucesso", listagem, true)
            );
        } catch(Exception e) {
            log.error("listarAgendamentos::: semana {}", semana);
            return ResponseEntity.badRequest().body(new ResponseGenericDTO("Listagem com erro "+ e, null, true));
        }
    }

    @GetMapping("/{salaId}/{semana}")
    public ResponseEntity<? extends ResponseGenericDTO> listarAgendamentosSala(@PathVariable Long salaId, @PathVariable int semana) {
        try {
            List<AgendamentoDTO> listagem = agendamentoService.listarAgendamentosSalaSemana(salaId, semana);
            return ResponseEntity.ok(
                    new ResponseGenericDTO("Listagem realizada com sucesso", listagem, true)
            );
        } catch(Exception e) {
            log.error("listarAgendamentosSala::: salaId {}  semana {}", salaId, semana);
            return ResponseEntity.badRequest().body(new ResponseGenericDTO("Listagem com erro "+ e, null, true));
        }
    }
}
