package dev.nishiduka.cae.telao.outbound;

import dev.nishiduka.cae.telao.core.domain.dtos.requests.AuthenticationDTO;
import dev.nishiduka.cae.telao.core.domain.dtos.requests.RegisterDTO;
import dev.nishiduka.cae.telao.core.domain.dtos.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    String login(AuthenticationDTO authentication);
    UserEntity criarUsuario(RegisterDTO register);
}
