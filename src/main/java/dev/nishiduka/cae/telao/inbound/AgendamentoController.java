package dev.nishiduka.cae.telao.inbound;

import dev.nishiduka.cae.telao.core.domain.dtos.requests.ResponseGenericDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;


public interface AgendamentoController {

    @GetMapping("/dia")
    ResponseEntity<? extends ResponseGenericDTO> listarAgendamentosDia(@RequestParam LocalDate data);

    @GetMapping("/semana/{salaId}")
    ResponseEntity<? extends ResponseGenericDTO> listarAgendamentos(@PathVariable int semana);

    @GetMapping("/{salaId}/semana/{semana}")
    public ResponseEntity<? extends ResponseGenericDTO> listarAgendamentosSala(@PathVariable Long salaId, @PathVariable int semana);
}
