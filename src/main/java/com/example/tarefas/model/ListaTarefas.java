package com.example.tarefas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "listaTarefas")
public class ListaTarefas {
    @Id
    private String id;
    private Date dataTarefa;
    private String descricaoTarefa;
    private String observacao;

    @DBRef
    private Prioridade prioridade;

    @DBRef
    private CategoriaTarefa categoriaTarefa;

    @DBRef
    private Status status;

    @DBRef
    private Responsavel responsavel;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDataTarefa() {
        return dataTarefa;
    }

    public void setDataTarefa(Date dataTarefa) {
        this.dataTarefa = dataTarefa;
    }

    public String getDescricaoTarefa() {
        return descricaoTarefa;
    }

    public void setDescricaoTarefa(String descricaoTarefa) {
        this.descricaoTarefa = descricaoTarefa;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public CategoriaTarefa getCategoriaTarefa() {
        return categoriaTarefa;
    }

    public void setCategoriaTarefa(CategoriaTarefa categoriaTarefa) {
        this.categoriaTarefa = categoriaTarefa;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }
}
