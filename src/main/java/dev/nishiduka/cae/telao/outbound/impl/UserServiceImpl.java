package dev.nishiduka.cae.telao.outbound.impl;

import dev.nishiduka.cae.telao.core.domain.dtos.requests.AuthenticationDTO;
import dev.nishiduka.cae.telao.core.domain.dtos.requests.RegisterDTO;
import dev.nishiduka.cae.telao.core.domain.dtos.UserEntity;
import dev.nishiduka.cae.telao.core.domain.exceptions.EntityAlreadyExistsException;
import dev.nishiduka.cae.telao.core.infra.security.TokenService;
import dev.nishiduka.cae.telao.core.repository.UserRepository;
import dev.nishiduka.cae.telao.outbound.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    public String login(AuthenticationDTO authentication) {
        UsernamePasswordAuthenticationToken userNamePassword = new UsernamePasswordAuthenticationToken(authentication.login(), authentication.password());

        Authentication auth = authManager.authenticate(userNamePassword);

        return tokenService.generateToken((UserEntity) auth.getPrincipal());
    }

    public UserEntity criarUsuario(RegisterDTO register) {
        if(userRepository.findByLogin(register.login()) != null) {
            throw new EntityAlreadyExistsException("Usuário já cadastrado");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(register.password());

        return userRepository.save(new UserEntity(null, register.login(), encryptedPassword, register.nome(), register.role()));
    }

}
