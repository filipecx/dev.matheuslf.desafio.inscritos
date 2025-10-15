package dev.matheuslf.desafio.inscritos.domain.repositories;

import dev.matheuslf.desafio.inscritos.domain.model.Project;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository {
    Project create(Project project);
    Project getProject(Long id);
    List<Project> getAll();
}
