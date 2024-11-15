package dev.nishiduka.cae.telao.core.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

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

    public static EDiaSemana fromLocalDateTime(LocalDateTime horario) {
        String nomeDoDia = horario.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("pt", "BR"));

        return EDiaSemana.valueOf(nomeDoDia.replace("-feira", "").toUpperCase());
    }

}
