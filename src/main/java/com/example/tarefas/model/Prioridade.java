package com.example.tarefas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "prioridades")
public class Prioridade {
    @Id
    private String id;
    private String descricao;

    // Construtores
    public Prioridade() {
    }

    public Prioridade(String descricao) {
        this.descricao = descricao;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc