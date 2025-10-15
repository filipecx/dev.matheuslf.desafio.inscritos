package dev.matheuslf.desafio.inscritos.application.usecases;

import dev.matheuslf.desafio.inscritos.domain.model.Project;
import dev.matheuslf.desafio.inscritos.domain.repositories.ProjectRepository;

public class CreateProjectUseCase {
    private final ProjectRepository repository;

    public CreateProjectUseCase(ProjectRepository repository){
        this.repository = repository;
    }

    public Project execute(Project project) {
        return this.repository.create(project);
    }

}
