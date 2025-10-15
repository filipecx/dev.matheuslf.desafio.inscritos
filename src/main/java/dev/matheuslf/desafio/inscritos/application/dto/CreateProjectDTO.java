package dev.matheuslf.desafio.inscritos.application.dto;

import java.time.LocalDate;

public record CreateProjectDTO(
        String name,
        String description,
        LocalDate startDate,
        LocalDate endDate
) {
}
