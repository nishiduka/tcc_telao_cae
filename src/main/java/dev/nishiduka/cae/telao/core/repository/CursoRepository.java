package dev.nishiduka.cae.telao.core.repository;

import dev.nishiduka.cae.telao.core.domain.dtos.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<CursoEntity, Long> { }
