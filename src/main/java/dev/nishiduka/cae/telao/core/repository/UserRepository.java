package dev.nishiduka.cae.telao.core.repository;

import dev.nishiduka.cae.telao.core.domain.dtos.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserDetails findByLogin(String login);
}
