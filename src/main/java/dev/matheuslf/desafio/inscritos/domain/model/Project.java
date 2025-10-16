package dev.matheuslf.desafio.inscritos.domain.model;

import dev.matheuslf.desafio.inscritos.domain.Exceptions.DomainException;

import java.time.LocalDate;

public class Project {
    private Long id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
/*
    public Project(){}; */

    public Project (Builder builder) {
        this.validateDate(builder.startDate, builder.endDate);
        this.validateName(builder.name);
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
    }

    public static class Builder {
        private Long id;
        private String name;
        private String description = null;
        private LocalDate startDate;
        private LocalDate endDate = null;

        public Builder (String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder endDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public Project build() {
            return new Project(this);
        }
    }



    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    private void validateDate(LocalDate startDate, LocalDate endDate) {
        if (startDate == null) {
            throw new DomainException("A data de início é obrigatória. ");
        }
        if (endDate == null) {
            return;
        }
        if (startDate.isAfter(endDate)) {
            throw new DomainException("A data de início não pode ser depois da data de término. ");
        }
    }

    private void validateName(String name) {
        if (name.length() < 3) {
            throw new DomainException("O nome do projeto não pode ter menos de três letras. ");
        }
    }

}
