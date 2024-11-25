package dev.nishiduka.cae.telao.core.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ETipoAgendamento {
    RECORRENTE("Recorrente"),
    PONTUAL("Pontual");

    private String tipo;
}
