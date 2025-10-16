package dev.matheuslf.desafio.inscritos.domain.repositories;

import dev.matheuslf.desafio.inscritos.domain.model.Task;
import dev.matheuslf.desafio.inscritos.domain.model.enums.Priority;
import dev.matheuslf.desafio.inscritos.domain.model.enums.Status;

import java.util.List;

public interface TaskRepository {
    Task create(Task task);
    List<Task> getAll();
    List<Task> findByFilters(Status status, Priority priority);
    void updateStatus(Long id, Status status);
    void delete(Long id);
}
