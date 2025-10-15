package dev.matheuslf.desafio.inscritos.infrastructure.persistence.repositories;

import dev.matheuslf.desafio.inscritos.application.exceptions.NotFoundException;
import dev.matheuslf.desafio.inscritos.domain.model.Project;
import dev.matheuslf.desafio.inscritos.domain.repositories.ProjectRepository;
import dev.matheuslf.desafio.inscritos.infrastructure.mappers.ProjectMapper;
import dev.matheuslf.desafio.inscritos.infrastructure.persistence.Entities.ProjectEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {
    private final JpaProjectRepository repository;
    private final ProjectMapper mapper;

    public ProjectRepositoryImpl(JpaProjectRepository repository, ProjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Project create(Project project) {
        ProjectEntity entity = this.mapper.toEntity(project);
        ProjectEntity persistedProject = this.repository.save(entity);
        return this.mapper.toDomain(persistedProject);
    }

    @Override
    public Project getProject(Long id) {
        ProjectEntity foundProject = this.repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Nenhum projeto com esse id encontrado"));
        return this.mapper.toDomain(foundProject);
    }

    @Override
    public List<Project> getAll() {
        List<ProjectEntity> listOfEntities = this.repository.findAll();
        return this.mapper.toDomainList(listOfEntities);
    }
}
