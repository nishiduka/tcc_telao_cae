package dev.nishiduka.cae.telao.inbound.impl;

import dev.nishiduka.cae.telao.core.domain.dtos.requests.AuthenticationDTO;
import dev.nishiduka.cae.telao.core.domain.dtos.requests.RegisterDTO;
import dev.nishiduka.cae.telao.core.domain.dtos.requests.ResponseGenericDTO;
import dev.nishiduka.cae.telao.core.domain.dtos.UserEntity;
import dev.nishiduka.cae.telao.core.domain.exceptions.EntityAlreadyExistsException;
import dev.nishiduka.cae.telao.outbound.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthorizationControllerImpl {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity login(@Valid @RequestBody AuthenticationDTO authentication) {
        String token = userService.login(authentication);

        return ResponseEntity.ok().body(new ResponseGenericDTO("Login efetuado com sucesso!", token, true));
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseGenericDTO> register(@Valid @RequestBody RegisterDTO register) {
        try {
            UserEntity user = userService.criarUsuario(register);
            return ResponseEntity.ok().body(new ResponseGenericDTO("Cadastro finalizado com sucesso!", user, true));
        } catch(EntityAlreadyExistsException ex) {
            return ResponseEntity.badRequest().body(new ResponseGenericDTO(ex.getMessage(), null, false));
        }
    }
}
