package dev.nishiduka.cae.telao.core.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public enum EDiaSemana {
    SEGUNDA("Segunda"),
    TERCA("Terça"),
    QUARTA("Quarta"),
    QUINTA("Quinta"),
    SEXTA("Sexta"),
    SABADO("Sábado"),
    DOMINGO("Domingo");

    private String dia;
}
