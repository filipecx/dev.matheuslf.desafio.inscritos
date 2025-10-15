package dev.matheuslf.desafio.inscritos.domain.repositories;

import dev.matheuslf.desafio.inscritos.domain.model.Task;

import java.util.List;

public interface TaskRepository {
    Task create(Task task);
    List<Task> getFiltered();
    void updateStatus(Task task);
    void delete(Long id);
}
