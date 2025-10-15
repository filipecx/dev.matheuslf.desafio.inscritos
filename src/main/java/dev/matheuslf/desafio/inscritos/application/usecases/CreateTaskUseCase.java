package dev.matheuslf.desafio.inscritos.application.usecases;

import dev.matheuslf.desafio.inscritos.domain.model.Project;
import dev.matheuslf.desafio.inscritos.domain.model.Task;
import dev.matheuslf.desafio.inscritos.domain.repositories.TaskRepository;

public class CreateTaskUseCase {
    private final GetProjectByIdUseCase getProjectByIdUseCase;
    private final TaskRepository repository;

    public CreateTaskUseCase(GetProjectByIdUseCase getProjectByIdUseCase, TaskRepository repository) {
        this.getProjectByIdUseCase = getProjectByIdUseCase;
        this.repository = repository;
    }

    public Task execute(Task task, Long id) {
        Project exists = getProjectByIdUseCase.execute(id);
        task.setProjectId(id);
        return repository.create(task);
    }
}
