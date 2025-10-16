package dev.matheuslf.desafio.inscritos.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.matheuslf.desafio.inscritos.application.dto.CreateProjectDTO;
import dev.matheuslf.desafio.inscritos.application.dto.ResponseProjectDTO;
import dev.matheuslf.desafio.inscritos.application.usecases.CreateProjectUseCase;
import dev.matheuslf.desafio.inscritos.application.usecases.GetAllProjectsUseCase;
import dev.matheuslf.desafio.inscritos.application.usecases.GetProjectByIdUseCase;
import dev.matheuslf.desafio.inscritos.domain.model.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProjectController.class)
class ProjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CreateProjectUseCase createProjectUseCase;

    @MockitoBean
    private GetAllProjectsUseCase getAllProjectsUseCase;

    @MockitoBean
    private GetProjectByIdUseCase getProjectByIdUseCase;

    @Autowired
    private ObjectMapper mapper;

    private CreateProjectDTO createProjectDTO;
    private ResponseProjectDTO responseProjectDTO;
    private Project project;

    @BeforeEach
    void setUp() {
        LocalDate startDate = LocalDate.now();

        createProjectDTO = new CreateProjectDTO("Projeto", null, startDate, null);
        project = new Project.Builder(createProjectDTO.name(), createProjectDTO.startDate()).id(1L).build();
    }

    @Test
    void itShouldReturn201() throws Exception {
        when(createProjectUseCase.execute(any(Project.class))).thenReturn(project);

        mockMvc.perform(post("/projects")
                .contentType("application/json")
                .content(mapper.writeValueAsString(createProjectDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value(createProjectDTO.name()))
                .andExpect(jsonPath("$.startDate").value(createProjectDTO.startDate().toString()));

        verify(createProjectUseCase, times(1)).execute(any(Project.class));
    }
}