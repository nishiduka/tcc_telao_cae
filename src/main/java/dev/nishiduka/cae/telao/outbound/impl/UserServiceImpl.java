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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<UserEntity> listarUsuario() {
        return userRepository.findAll().stream().map(item -> {
            return new UserEntity(item.getId(), item.getLogin(), null, item.getNome(), item.getRole());
        }).toList();
    }

    @Override
    public UserEntity buscarUsuario(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new EntityAlreadyExistsException("Usuário não encontrado"));
        return new UserEntity(user.getId(), user.getLogin(), null, user.getNome(), user.getRole());
    }

    @Override
    public UserEntity atualizarUsuario(Long id, RegisterDTO register) {
        UserDetails user = userRepository.findByLogin(register.login());

        if(user == null) {
            throw new EntityAlreadyExistsException("Usuário não encontrado");
        }

        String encryptedPassword = user.getPassword();
        if(register.password() != null && !register.password().isEmpty()) {
            encryptedPassword = new BCryptPasswordEncoder().encode(register.password());
        }

        return userRepository.save(new UserEntity(id, register.login(), encryptedPassword, register.nome(), register.role()));
    }

    @Override
    public void remover(Long id) {
        userRepository.deleteById(id);
    }

}
