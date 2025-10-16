package dev.matheuslf.desafio.inscritos.application.dto;

import dev.matheuslf.desafio.inscritos.domain.model.enums.Priority;
import dev.matheuslf.desafio.inscritos.domain.model.enums.Status;

public record FilterDTO(
        Status status,
        Priority priority
) {
}
