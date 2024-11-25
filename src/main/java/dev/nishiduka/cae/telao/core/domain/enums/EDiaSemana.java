package dev.nishiduka.cae.telao.core.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

@Getter
@AllArgsConstructor
public enum EDiaSemana {
    SEGUNDA("segunda-feira"),
    TERCA("terça-feira"),
    QUARTA("quarta-feira"),
    QUINTA("quinta-feira"),
    SEXTA("sexta-feira"),
    SABADO("sábado"),
    DOMINGO("domingo");

    private String dia;

    public static EDiaSemana fromLocalDateTime(LocalDateTime horario) {
        String nomeDoDia = horario.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("pt", "BR"));
        return fromDescricao(nomeDoDia);
    }

    public static EDiaSemana fromLocalDate(LocalDate horario) {
        String nomeDoDia = horario.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("pt", "BR"));
        return fromDescricao(nomeDoDia);
    }

    public static EDiaSemana fromDescricao(String descricao) {
        for (EDiaSemana dia : EDiaSemana.values()) {
            if (dia.getDia().equalsIgnoreCase(descricao)) {
                return dia;
            }
        }
        throw new IllegalArgumentException("Dia da semana não encontrado: " + descricao);
    }
}
