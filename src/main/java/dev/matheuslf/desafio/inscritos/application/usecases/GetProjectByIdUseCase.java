package dev.matheuslf.desafio.inscritos.application.usecases;

import dev.matheuslf.desafio.inscritos.application.exceptions.NotFoundException;
import dev.matheuslf.desafio.inscritos.domain.model.Project;
import dev.matheuslf.desafio.inscritos.domain.repositories.ProjectRepository;

public class GetProjectByIdUseCase {
    private final ProjectRepository repository;

    public GetProjectByIdUseCase(ProjectRepository repository) {
        this.repository = repository;
    }

    public Project execute(Long id) {
        return this.repository.getProject(id)
                .orElseThrow(() -> new NotFoundException("Nenhum projeto com esse id encontrado"));
    }
}
