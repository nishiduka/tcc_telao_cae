package dev.nishiduka.cae.telao.core.repository;

import dev.nishiduka.cae.telao.core.domain.dtos.MateriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaRepository extends JpaRepository<MateriaEntity, Long> { }
