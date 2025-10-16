package dev.matheuslf.desafio.inscritos.application.dto;

import dev.matheuslf.desafio.inscritos.domain.model.enums.Priority;
import dev.matheuslf.desafio.inscritos.domain.model.enums.Status;

import java.time.LocalDate;

public record ResponseTaskDTO(
        Long id,
        String title,
        String description,
        Status status,
        Priority priority,
        LocalDate dueDate,
        Long projectId
) {
}
