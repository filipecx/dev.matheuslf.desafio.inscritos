package dev.matheuslf.desafio.inscritos.infrastructure.mappers;

import dev.matheuslf.desafio.inscritos.domain.model.Project;
import dev.matheuslf.desafio.inscritos.infrastructure.persistence.Entities.ProjectEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectMapper {

    public Project  toDomain(ProjectEntity entity) {
        return new Project.Builder(entity.getName(), entity.getStartDate()).id(entity.getId()).description(entity.getDescription()).endDate(entity.getEndDate()).build();
    }

    public ProjectEntity toEntity(Project domain) {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setName(domain.getName());
        projectEntity.setStartDate(domain.getStartDate());
        projectEntity.setDescription(domain.getDescription());
        projectEntity.setEndDate(domain.getEndDate());

        return projectEntity;
    }

    public List<Project> toDomainList(List<ProjectEntity> listOfEntities) {

        return listOfEntities.stream().map(this::toDomain).toList();
    }
}
