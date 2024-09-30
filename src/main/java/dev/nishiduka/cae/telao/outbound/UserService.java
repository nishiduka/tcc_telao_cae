package dev.nishiduka.cae.telao.outbound;

import dev.nishiduka.cae.telao.core.domain.dtos.AuthenticationDTO;
import dev.nishiduka.cae.telao.core.domain.dtos.RegisterDTO;
import dev.nishiduka.cae.telao.core.domain.dtos.UserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    String login(AuthenticationDTO authentication);
    UserEntity criarUsuario(RegisterDTO register);
}
