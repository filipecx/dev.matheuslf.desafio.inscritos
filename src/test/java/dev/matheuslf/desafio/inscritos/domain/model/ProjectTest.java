package dev.matheuslf.desafio.inscritos.domain.model;

import dev.matheuslf.desafio.inscritos.domain.Exceptions.DomainException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    @Test
    @DisplayName("It should be able to create a project with mandatory fields only")
    void shouldCreateProject() {
        String name = "Projeto";
        LocalDate startDate = LocalDate.now();
        Project project = new Project.Builder(name, startDate).build();

        assertEquals(name, project.getName());
        assertEquals(startDate, project.getStartDate());
        assertNull(project.getDescription(), "A descrição opcional deve ser null");
        assertNull(project.getEndDate(), "A data de término opcional deve ser null");

    }

    @Test
    @DisplayName("Is should be able to create a project with all fields")
    void shouldCreateProjectWithAllFields() {
        String name = "Projeto";
        String description = "A descrição do projeto deve conter suas características e objetivos";
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusMonths(2);

        Project project = new Project.Builder(name, startDate)
                .description(description)
                .endDate(endDate)
                .build();

        assertEquals(name, project.getName());
        assertEquals(endDate, project.getEndDate());
        assertEquals(description, project.getDescription());
    }

    @Test
    @DisplayName("It should not allow to create a project with end date before start date")
    void shouldThrownDomainExceptionInvalidDate() {
        String name = "Projeto";
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.minusMonths(5);

        assertThrows(DomainException.class, () -> {
            new Project.Builder(name, startDate).endDate(endDate).build();
        });

    }

    @Test
    @DisplayName("It should not allow to create a project with invalid name")
    void shouldThrowDomainExceptionName() {
        String name = "Pr";
        LocalDate startDate = LocalDate.now();

        assertThrows(DomainException.class, () -> {
           new Project.Builder(name, startDate).build();
        });
    }



}