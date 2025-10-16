package dev.matheuslf.desafio.inscritos.infrastructure.persistence.repositories;

import dev.matheuslf.desafio.inscritos.application.exceptions.NotFoundException;
import dev.matheuslf.desafio.inscritos.domain.model.Task;
import dev.matheuslf.desafio.inscritos.domain.model.enums.Priority;
import dev.matheuslf.desafio.inscritos.domain.model.enums.Status;
import dev.matheuslf.desafio.inscritos.domain.repositories.TaskRepository;
import dev.matheuslf.desafio.inscritos.infrastructure.mappers.TaskMapper;
import dev.matheuslf.desafio.inscritos.infrastructure.persistence.Entities.TasksEntity;

import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {
    private final JpaTaskRepository repository;
    private final TaskMapper mapper;

    public TaskRepositoryImpl(JpaTaskRepository repository, TaskMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Task create(Task task) {
        TasksEntity taskToPersist = this.mapper.toEntity(task);
        TasksEntity persistedTask = this.repository.save(taskToPersist);
        return this.mapper.toDomain(persistedTask);
    }

    @Override
    public List<Task> getAll() {
        List<TasksEntity> listOfTasks = this.repository.findAll();
        return this.mapper.toDomainList(listOfTasks);
    }

    @Override
    public List<Task> findByFilters(Status status, Priority priority) {
        if (status == null) {
            List<TasksEntity> entities = this.repository.findByPriority(priority);
            return this.mapper.toDomainList(entities);
        }
        if (priority == null) {
            List<TasksEntity> entities = this.repository.findByStatus(status);
            return this.mapper.toDomainList(entities);
        }
        List<TasksEntity> entities = this.repository.findByStatusAndPriority(status, priority);
        return this.mapper.toDomainList(entities);
    }

    @Override
    public void updateStatus(Task task) {
        TasksEntity taskToUpdate = this.mapper.toEntity(task);
        this.repository.findById(taskToUpdate.getId())
                .orElseThrow(() -> new NotFoundException("Nenhuma task com esse id encontrada"));
        TasksEntity updatedTask = this.repository.save(taskToUpdate);
    }

    @Override
    public void delete(Long id) {
        this.repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Nenhuma task com esse id encontrada"));
        this.repository.deleteById(id);
    }
}
