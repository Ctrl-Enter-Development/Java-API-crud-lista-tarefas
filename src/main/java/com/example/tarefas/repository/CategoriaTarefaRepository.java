package com.example.tarefas.repository;

import com.example.tarefas.model.CategoriaTarefa;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoriaTarefaRepository extends MongoRepository<CategoriaTarefa, String> {
}
