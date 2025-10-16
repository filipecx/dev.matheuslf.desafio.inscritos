package dev.matheuslf.desafio.inscritos.infrastructure.persistence.Exceptions;

public class NotFound extends RuntimeException{
    public NotFound(String message) {
        super(message);
    }
}
