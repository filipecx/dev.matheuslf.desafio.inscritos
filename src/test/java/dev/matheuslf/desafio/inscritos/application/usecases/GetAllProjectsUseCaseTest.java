package dev.matheuslf.desafio.inscritos.application.usecases;

import dev.matheuslf.desafio.inscritos.domain.model.Project;
import dev.matheuslf.desafio.inscritos.domain.repositories.ProjectRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetAllProjectsUseCaseTest {

    @InjectMocks
    private GetAllProjectsUseCase getAllProjectsUseCase;
    @Mock
    private ProjectRepository repository;

    String name = "Projeto";
    LocalDate startDate = LocalDate.now();
    Project persistedProject = new Project.Builder(name, startDate).id(1234L).build();
    List<Project> projects = new ArrayList<Project>();


    @Test
    @DisplayName("It should return all the projects or an empty list")
    void getAllProjects() {
        projects.add(persistedProject);
        when(repository.getAll()).thenReturn(projects);
        List<Project> persistedProjects = getAllProjectsUseCase.execute();
        verify(repository, Mockito.times(1)).getAll();
        assertEquals(1, persistedProjects.size());
    }
}