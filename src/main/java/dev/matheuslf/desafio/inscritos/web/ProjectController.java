package dev.matheuslf.desafio.inscritos.web;

import dev.matheuslf.desafio.inscritos.application.dto.CreateProjectDTO;
import dev.matheuslf.desafio.inscritos.application.dto.ResponseProjectDTO;
import dev.matheuslf.desafio.inscritos.application.usecases.CreateProjectUseCase;
import dev.matheuslf.desafio.inscritos.application.usecases.GetAllProjectsUseCase;
import dev.matheuslf.desafio.inscritos.application.usecases.GetProjectByIdUseCase;
import dev.matheuslf.desafio.inscritos.domain.model.Project;
import dev.matheuslf.desafio.inscritos.infrastructure.persistence.repositories.ProjectRepositoryImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final CreateProjectUseCase createUsecase;
    private final GetProjectByIdUseCase getByIdUsecase;
    private final GetAllProjectsUseCase getAllUsecase;

    ProjectController(

            CreateProjectUseCase createUsecase,
            GetProjectByIdUseCase getByIdUsecase,
            GetAllProjectsUseCase getAllUsecase){

        this.createUsecase = createUsecase;
        this.getByIdUsecase = getByIdUsecase;
        this.getAllUsecase = getAllUsecase;
    }

    @GetMapping("/{id}")
    public ResponseProjectDTO getProject(@PathVariable Long id){
        Project project = this.getByIdUsecase.execute(id);

        ResponseProjectDTO responseProjectDTO = new ResponseProjectDTO(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getStartDate(),
                project.getEndDate()
        );
        return responseProjectDTO;
    }

    @GetMapping
    public List<ResponseProjectDTO> getAllProjects(){
        List<Project> projects = this.getAllUsecase.execute();

        List<ResponseProjectDTO> responseProjectDTOList = projects.stream()
                .map(project -> {
                    return new ResponseProjectDTO(
                            project.getId(),
                            project.getName(),
                            project.getDescription(),
                            project.getStartDate(),
                            project.getEndDate()
                    );
                }).toList();

        return responseProjectDTOList;
    }

    @PostMapping
    public ResponseEntity<ResponseProjectDTO> createProject(@RequestBody CreateProjectDTO projectDTO){

        Project inputProject = new Project.Builder(
                projectDTO.name(),
                projectDTO.startDate())
                .description(projectDTO.description())
                .endDate(projectDTO.endDate()).build();

        Project project = this.createUsecase.execute(inputProject);
        ResponseProjectDTO responseProjectDTO = new ResponseProjectDTO(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getStartDate(),
                project.getEndDate()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(responseProjectDTO);
    }
}
