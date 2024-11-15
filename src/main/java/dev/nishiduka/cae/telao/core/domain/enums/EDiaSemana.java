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

        return normalizarDiaSemana(nomeDoDia);
    }

    private static EDiaSemana normalizarDiaSemana(String dia)  {
        if(dia == "segunda-feira") return EDiaSemana.SEGUNDA;
        if(dia == "terça-feira") return EDiaSemana.TERCA;
        if(dia == "quarta-feira") return EDiaSemana.QUARTA;
        if(dia == "quinta-feira") return EDiaSemana.QUINTA;
        if(dia == "sexta-feira") return EDiaSemana.SEXTA;
        if(dia == "sábado") return EDiaSemana.SABADO;
        if(dia == "doming") return EDiaSemana.DOMINGO;

        return null;
    }

}
