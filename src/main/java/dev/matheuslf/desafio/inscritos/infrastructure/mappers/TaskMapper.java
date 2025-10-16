package dev.matheuslf.desafio.inscritos.infrastructure.mappers;

import dev.matheuslf.desafio.inscritos.domain.model.Task;
import dev.matheuslf.desafio.inscritos.infrastructure.persistence.Entities.TasksEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(target = "projectId", source = "project.id")
    Task toDomain(TasksEntity entity);

    @Mapping(target = "project.id", source = "projectId")
    TasksEntity toEntity(Task domain);

    List<Task> toDomainList(List<TasksEntity> entityList);
}
