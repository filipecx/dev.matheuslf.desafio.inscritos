package dev.matheuslf.desafio.inscritos.domain.repositories;

import dev.matheuslf.desafio.inscritos.domain.model.Project;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository {
    Project create(Project project);
    List<Project> getAll();
}
