package dev.matheuslf.desafio.inscritos.application.usecases;

import dev.matheuslf.desafio.inscritos.domain.model.Task;
import dev.matheuslf.desafio.inscritos.domain.model.enums.Priority;
import dev.matheuslf.desafio.inscritos.domain.model.enums.Status;
import dev.matheuslf.desafio.inscritos.domain.repositories.TaskRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateTaskUseCaseTest {

    @InjectMocks
    private UpdateTaskUseCase useCase;

    @Mock
    private TaskRepository repository;

    LocalDate dueDate = LocalDate.now().plusDays(10);

    Task task = new Task("task1", "a important task", Status.DOING, Priority.HIGH, dueDate);



    @Test
    @DisplayName("It should be able to change task status")
    void shouldChangStatus() {
        task.setProjectId(1245L);
        task.changeStatus(Status.DONE);
        this.useCase.execute(12l, task.getStatus());
        verify(repository, Mockito.times(1)).updateStatus(12L, task.getStatus());
    }

}