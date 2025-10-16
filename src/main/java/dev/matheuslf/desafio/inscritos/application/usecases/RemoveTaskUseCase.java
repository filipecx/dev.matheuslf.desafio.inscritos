package dev.matheuslf.desafio.inscritos.application.usecases;

import dev.matheuslf.desafio.inscritos.domain.repositories.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class RemoveTaskUseCase {
    private TaskRepository repository;

    public RemoveTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public void execute(Long id) {
        this.repository.delete(id);
    }
}
