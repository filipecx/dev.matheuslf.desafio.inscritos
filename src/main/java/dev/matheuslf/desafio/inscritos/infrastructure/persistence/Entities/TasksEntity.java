package dev.matheuslf.desafio.inscritos.infrastructure.persistence.Entities;

import dev.matheuslf.desafio.inscritos.domain.model.Project;
import dev.matheuslf.desafio.inscritos.domain.model.enums.Priority;
import dev.matheuslf.desafio.inscritos.domain.model.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Table(name = "tasks")
@Data // ESSENCIAL: Garante Getters e Setters para o MapStruct
@NoArgsConstructor // ESSENCIAL: Necessário para o JPA (Hibernate)
@AllArgsConstructor // Opcional, mas útil
public class TasksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private ProjectEntity project;
}
