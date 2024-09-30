package dev.nishiduka.cae.telao.core.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

@AllArgsConstructor
@Getter
public enum EUserRole {
    ADMIN("ADMIN", List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"))),
    USER("USER", List.of(new SimpleGrantedAuthority("ROLE_USER")));

    private String role;
    private List<SimpleGrantedAuthority> authorities;
}
