package dev.matheuslf.desafio.inscritos.application.dto;

import java.time.LocalDate;

public record ResponseProjectDTO(
        Long id,
        String name,
        String description,
        LocalDate startDate,
        LocalDate endDate
) {
}
