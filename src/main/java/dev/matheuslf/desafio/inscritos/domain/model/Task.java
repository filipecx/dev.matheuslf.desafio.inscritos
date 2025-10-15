package dev.matheuslf.desafio.inscritos.domain.model;

import dev.matheuslf.desafio.inscritos.domain.Exceptions.DomainException;
import dev.matheuslf.desafio.inscritos.domain.model.enums.Priority;
import dev.matheuslf.desafio.inscritos.domain.model.enums.Status;

import java.time.LocalDate;

public class Task {
    private Long id;
    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private LocalDate dueDate;

    public Task(String title, String description, Status status, Priority priority, LocalDate dueDate) {
        this.validateTitle(title);
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public Status getStatus() {
        return this.status;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    public void changeTitle(String newTitle) {
        validateTitle(newTitle);
        this.title = newTitle;
    }

    public void changeDescription(String newDescription) {
        this.description = newDescription;
    }

    public void changeStatus(Status newStatus) {
        this.status = newStatus;
    }

    public void changePriority(Priority newPriority) {
        this.priority = newPriority;
    }

    private void validateTitle(String title) {
        if (title == null) {
            throw new DomainException("Você deve inserir um título para criar uma tarefa");
        }
        if (title.length() < 5) {
            throw new DomainException("O título da tarefa deve ter pelo menos 5 caracteres");
        }
        if (title.length() > 150) {
            throw new DomainException("O título da tarefa não pode passar de 150 caracteres");
        }
    }


}
