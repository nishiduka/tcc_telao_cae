package dev.nishiduka.cae.telao.core.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseGenericDTO {
    private String message;
    private Object content;
    private boolean success;
}
