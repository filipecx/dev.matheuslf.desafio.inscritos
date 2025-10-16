package dev.matheuslf.desafio.inscritos.domain.model;

import dev.matheuslf.desafio.inscritos.domain.Exceptions.DomainException;
import dev.matheuslf.desafio.inscritos.domain.model.enums.Priority;
import dev.matheuslf.desafio.inscritos.domain.model.enums.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    private Task validTask;

    @Test
    @DisplayName("It should be able to create a task")
    void itShouldCreateNewTask() {
        LocalDate dueDate = LocalDate.now().plusDays(4);
        Task task = new Task(
                "task1",
                "A really important task",
                Status.TODO,
                Priority.HIGH,
                dueDate
        );

        assertNotNull(task);
        assertEquals("task1", task.getTitle());
        assertEquals("A really important task", task.getDescription());
        assertEquals(Status.TODO, task.getStatus());
        assertEquals(Priority.HIGH, task.getPriority());
        assertEquals(dueDate, task.getDueDate());
    }

    @Test
    @DisplayName("It should not be able to create a task without a valid title")
    void itShouldNotCreateTask() {
        LocalDate dueDate = LocalDate.now().plusDays(4);

        assertThrows(DomainException.class, () -> {
            new Task(
                    "task",
                    "A really important task",
                    Status.TODO,
                    Priority.HIGH,
                    dueDate
            );
        });
    }

    @BeforeEach
    void setup() {
        LocalDate dueDate = LocalDate.now().plusDays(4);
        this.validTask = new Task(
                "task1",
                "A really important task",
                Status.TODO,
                Priority.HIGH,
                dueDate
        );
    }

    @Test
    @DisplayName("It should be able to change the title")
    void changeTitle() {
        validTask.changeTitle("task2");
        assertEquals("task2", validTask.getTitle());
    }

    @Test
    @DisplayName("It should not be able to change the title")
    void cantChangeTitle() {
        assertThrows(DomainException.class, () -> {
            validTask.changeTitle("tas");
        });
        assertNotEquals("tas", validTask.getTitle());
    }


    @Test
    @DisplayName("It should be able to change the description")
    void changeDescription() {
        validTask.changeDescription("A not so important task");
        assertEquals("A not so important task", validTask.getDescription());
    }

    @Test
    @DisplayName("It should be able to change the status")
    void changeStatus() {
        validTask.changeStatus(Status.DOING);
        assertEquals(Status.DOING, validTask.getStatus());
    }

    @Test
    @DisplayName("It should be able to change the priority")
    void changePriority() {
        validTask.changePriority(Priority.MEDIUM);
        assertEquals(Priority.MEDIUM, validTask.getPriority());
    }
}