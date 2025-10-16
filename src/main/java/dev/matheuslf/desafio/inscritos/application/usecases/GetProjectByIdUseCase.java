package dev.matheuslf.desafio.inscritos.application.usecases;

import dev.matheuslf.desafio.inscritos.domain.model.Project;
import dev.matheuslf.desafio.inscritos.domain.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class GetProjectByIdUseCase {
    private final ProjectRepository repository;

    public GetProjectByIdUseCase(ProjectRepository repository) {
        this.repository = repository;
    }

    public Project execute(Long id) {
        return this.repository.getProject(id);
    }
}
