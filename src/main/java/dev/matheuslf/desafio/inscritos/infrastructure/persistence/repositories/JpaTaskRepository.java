package dev.matheuslf.desafio.inscritos.infrastructure.persistence.repositories;

import dev.matheuslf.desafio.inscritos.domain.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTaskRepository extends JpaRepository<Task, Long> {
}
