package dev.matheuslf.desafio.inscritos.web;

import dev.matheuslf.desafio.inscritos.application.dto.CreateTaskDTO;
import dev.matheuslf.desafio.inscritos.application.dto.ResponseProjectDTO;
import dev.matheuslf.desafio.inscritos.application.dto.ResponseTaskDTO;
import dev.matheuslf.desafio.inscritos.application.usecases.*;
import dev.matheuslf.desafio.inscritos.domain.model.Task;
import dev.matheuslf.desafio.inscritos.domain.model.enums.Priority;
import dev.matheuslf.desafio.inscritos.domain.model.enums.Status;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@Tag(name = "tasks", description = "Endpoint para gerenciar tarefas")

public class TaskController {

    private final CreateTaskUseCase createTaskUseCase;
    private final GetFilteredTasksUseCase getFilteredTasksUseCase;
    private final RemoveTaskUseCase removeTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;

    TaskController(
            CreateTaskUseCase createTaskUseCase,
            GetFilteredTasksUseCase getFilteredTasksUseCase,
            GetTasksUseCase getTasksUseCase,
            RemoveTaskUseCase removeTaskUseCase,
            UpdateTaskUseCase updateTaskUseCase
    ){
        this.createTaskUseCase = createTaskUseCase;
        this.getFilteredTasksUseCase = getFilteredTasksUseCase;
        this.removeTaskUseCase = removeTaskUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
    }

    @GetMapping
    @Operation(summary = "Retorna as tarefas filtradas", description = "Caso não haja filtros, retornará todas as tarefas. Os filtros são individuais e opcionais")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseTaskDTO.class))))
    })
    public List<ResponseTaskDTO> getAllTasks(
            @Parameter(description = "Filtra tasks por status TODO, DOING, DONE")
            @RequestParam(required = false) Status status,

            @Parameter(description = "Filtra tasks por priority LOW, MEDIUM, HIGH")
            @RequestParam(required = false) Priority priority) {
        List<Task> listOfTasks = this.getFilteredTasksUseCase.execute(status, priority);
        List<ResponseTaskDTO> listOfDtos = listOfTasks.stream().map(task -> {
                return new ResponseTaskDTO(
                        task.getId(),
                        task.getTitle(),
                        task.getDescription(),
                        task.getStatus(),
                        task.getPriority(),
                        task.getDueDate(),
                        task.getProjectId()
                );
        }).toList();

        return listOfDtos;
    }

    @PostMapping
    @Operation(summary = "Cria nova task")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = ResponseTaskDTO.class)))
    })
    public ResponseEntity<ResponseTaskDTO> createTask(
            @Valid
            @RequestBody CreateTaskDTO taskDTO) {
        Task task = new Task(
                taskDTO.title(),
                taskDTO.description(),
                taskDTO.status(),
                taskDTO.priority(),
                taskDTO.dueDate()
        );

        Task createdTask = this.createTaskUseCase.execute(task, taskDTO.projectId());

        ResponseTaskDTO responseTaskDTO = new ResponseTaskDTO(
                createdTask.getId(),
                createdTask.getTitle(),
                createdTask.getDescription(),
                createdTask.getStatus(),
                createdTask.getPriority(),
                createdTask.getDueDate(),
                createdTask.getProjectId()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(responseTaskDTO);
    }

    @PutMapping("/{id}/status")
    @Operation(summary = "Atualiza o status de uma task")
    public void updateStatus(@PathVariable Long id, @RequestBody Status status) {
        this.updateTaskUseCase.execute(id, status);
    }


    @DeleteMapping
    @Operation(summary = "Deleta uma task")
    public void deleteTask(@PathVariable Long id) {
        this.removeTaskUseCase.execute(id);
    }

}
