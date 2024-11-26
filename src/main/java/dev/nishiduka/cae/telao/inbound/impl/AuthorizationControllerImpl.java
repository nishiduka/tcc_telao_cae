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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/auth")
public class AuthorizationControllerImpl {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<ResponseGenericDTO> login(@Valid @RequestBody AuthenticationDTO authentication) {
        String token = userService.login(authentication);

        return ResponseEntity.ok().body(new ResponseGenericDTO("Login efetuado com sucesso!", token, true));
    }

    @GetMapping("/")
    public ResponseEntity<ResponseGenericDTO> currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity currentUser = (UserEntity) authentication.getPrincipal();

        HashMap<String, Object> user = new HashMap<>();
        user.put("id", currentUser.getId());
        user.put("nome", currentUser.getNome());
        user.put("email", currentUser.getLogin());

        return ResponseEntity.ok().body(new ResponseGenericDTO("Dados recuperados com sucesso!", user, true));
    }

    @GetMapping("/listagem")
    public ResponseEntity<ResponseGenericDTO> listarUsuario() {
        return ResponseEntity.ok().body(new ResponseGenericDTO("Dados recuperados com sucesso!", userService.listarUsuario(), true));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<ResponseGenericDTO> retriveUser(@PathVariable Long id) {
        return ResponseEntity.ok().body(new ResponseGenericDTO("Dados recuperados com sucesso!", userService.buscarUsuario(id), true));
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseGenericDTO> register(@Valid @RequestBody RegisterDTO register) {
        try {
            UserEntity user = userService.criarUsuario(register);
            return ResponseEntity.ok().body(new ResponseGenericDTO("Cadastro realizado com sucesso!", user, true));
        } catch(EntityAlreadyExistsException ex) {
            return ResponseEntity.badRequest().body(new ResponseGenericDTO(ex.getMessage(), null, false));
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseGenericDTO> update(@Valid @RequestBody RegisterDTO register, @PathVariable Long id) {
        try {
            UserEntity user = userService.atualizarUsuario(id, register);
            return ResponseEntity.ok().body(new ResponseGenericDTO("Cadastro atualizado com sucesso!", user, true));
        } catch(EntityAlreadyExistsException ex) {
            return ResponseEntity.badRequest().body(new ResponseGenericDTO(ex.getMessage(), null, false));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseGenericDTO> remove(@PathVariable Long id) {
        try {
            userService.remover(id);
            return ResponseEntity.ok().body(new ResponseGenericDTO("Usuario removido com sucesso!", null, true));
        } catch(EntityAlreadyExistsException ex) {
            return ResponseEntity.badRequest().body(new ResponseGenericDTO(ex.getMessage(), null, false));
        }
    }
}
