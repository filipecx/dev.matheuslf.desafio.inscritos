package dev.matheuslf.desafio.inscritos.application.dto;

import dev.matheuslf.desafio.inscritos.domain.model.enums.Priority;
import dev.matheuslf.desafio.inscritos.domain.model.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CreateTaskDTO(
        @NotBlank
        @Size(min = 5, max = 150, message = "O titulo da tarefa deve ter entre {min} e {max} caracteres")
        String title,
        String description,
        Status status,
        Priority priority,
        LocalDate dueDate,
        Long projectId
) {
}
