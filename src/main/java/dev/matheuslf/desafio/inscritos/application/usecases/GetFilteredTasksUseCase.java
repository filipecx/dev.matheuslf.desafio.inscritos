package dev.matheuslf.desafio.inscritos.application.usecases;

import dev.matheuslf.desafio.inscritos.domain.model.Task;
import dev.matheuslf.desafio.inscritos.domain.model.enums.Priority;
import dev.matheuslf.desafio.inscritos.domain.model.enums.Status;
import dev.matheuslf.desafio.inscritos.domain.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetFilteredTasksUseCase {
    private final TaskRepository repository;

    public GetFilteredTasksUseCase(TaskRepository repository){
        this.repository = repository;
    }

    public List<Task> execute(Status status, Priority priority) {
        return this.repository.findByFilters(status, priority);
    }

}
