package dev.matheuslf.desafio.inscritos.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CreateProjectDTO(
        @NotBlank(message = "O projeto deve ter um nome")
        @Size(min = 3, max = 100, message = "O nome do projeto deve ter entre {min} e {max} caracteres")
        String name,
        String description,
        LocalDate startDate,
        LocalDate endDate
) {
}
