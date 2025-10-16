package dev.matheuslf.desafio.inscritos.infrastructure.mappers;

import dev.matheuslf.desafio.inscritos.domain.model.Task;
import dev.matheuslf.desafio.inscritos.infrastructure.persistence.Entities.TasksEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    Task toDomain(TasksEntity entity);

    TasksEntity toEntity(Task domain);

    List<Task> toDomainList(List<TasksEntity> entityList);
}
