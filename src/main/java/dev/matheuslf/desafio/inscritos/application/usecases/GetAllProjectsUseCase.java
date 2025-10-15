package dev.matheuslf.desafio.inscritos.application.usecases;

import dev.matheuslf.desafio.inscritos.domain.model.Project;
import dev.matheuslf.desafio.inscritos.domain.repositories.ProjectRepository;

import java.util.List;

public class GetAllProjectsUseCase {
    private final ProjectRepository repository;
    public GetAllProjectsUseCase(ProjectRepository repository) {
        this.repository = repository;
    }

    public List<Project> execute() {
        return this.repository.getAll();
    }
}
