package dev.matheuslf.desafio.inscritos.infrastructure.persistence.repositories;

import dev.matheuslf.desafio.inscritos.infrastructure.persistence.Entities.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProjectRepository extends JpaRepository<ProjectEntity, Long> {
}
