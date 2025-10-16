package dev.matheuslf.desafio.inscritos.infrastructure.persistence.repositories;

import dev.matheuslf.desafio.inscritos.domain.model.enums.Priority;
import dev.matheuslf.desafio.inscritos.domain.model.enums.Status;
import dev.matheuslf.desafio.inscritos.infrastructure.persistence.Entities.TasksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaTaskRepository extends JpaRepository<TasksEntity, Long> {
    List<TasksEntity> findByStatusAndPriority(Status status, Priority priority);
    List<TasksEntity> findByStatus(Status status);
    List<TasksEntity> findByPriority(Priority priority);
}
