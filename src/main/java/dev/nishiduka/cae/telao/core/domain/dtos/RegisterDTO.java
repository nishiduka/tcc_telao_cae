package dev.nishiduka.cae.telao.core.domain.dtos;

import dev.nishiduka.cae.telao.core.domain.enums.EUserRole;

public record RegisterDTO(String login, String password, String nome, EUserRole role) { }
