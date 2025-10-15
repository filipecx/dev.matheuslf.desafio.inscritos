package dev.matheuslf.desafio.inscritos.application.usecases;

import dev.matheuslf.desafio.inscritos.domain.model.Project;
import dev.matheuslf.desafio.inscritos.domain.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateProjectUseCaseTest {

    @InjectMocks
    private CreateProjectUseCase createProjectUseCase;
    @Mock
    private ProjectRepository repository;

    String name = "Projeto";
    LocalDate startDate = LocalDate.now();
    Project project = new Project.Builder(name, startDate).build();
    Project persistedProject = new Project.Builder(name, startDate).id(1234L).build();

    @Test
    void createProject() {

        when(repository.create(project)).thenReturn(persistedProject);

        Project createdProject = createProjectUseCase.execute(project);

        assertEquals(1234L, createdProject.getId());
        verify(repository, Mockito.times(1)).create(any(Project.class));
    }
}