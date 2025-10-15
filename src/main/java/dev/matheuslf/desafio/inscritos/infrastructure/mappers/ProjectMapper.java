package dev.matheuslf.desafio.inscritos.infrastructure.mappers;

import dev.matheuslf.desafio.inscritos.domain.model.Project;
import dev.matheuslf.desafio.inscritos.infrastructure.persistence.Entities.ProjectEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    Project toDomain(ProjectEntity entity);

    ProjectEntity toEntity(Project domain);

    List<Project> toDomainList(List<ProjectEntity> entities);

    List<ProjectEntity> toJpaEntityList(List<Project> domainList);

}
