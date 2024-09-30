package dev.nishiduka.cae.telao.core.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import dev.nishiduka.cae.telao.core.domain.dtos.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

@Service
@Slf4j
public class TokenService {
    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(UserEntity user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(user.getLogin())
                    .withExpiresAt(genExpereDate())
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao gerar token: " + e.getMessage());
        }
    }

    public String isValidToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            log.error("Erro ao verificar token: " + e.getMessage());
            return "";
        }
    }

    private Instant genExpereDate() {
        return LocalDateTime.now().plus(1, ChronoUnit.HOURS).toInstant(ZoneOffset.of("-03:00"));
    }
}
