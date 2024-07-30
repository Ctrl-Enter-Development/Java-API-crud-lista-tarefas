package com.example.tarefas.exception;

public class CategoriaTarefaNotFoundException extends RuntimeException {
    public CategoriaTarefaNotFoundException(String message) {
        super(message);
    }
}
