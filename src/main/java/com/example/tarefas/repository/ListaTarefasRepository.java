package com.example.tarefas.repository;

import com.example.tarefas.model.ListaTarefas;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ListaTarefasRepository extends MongoRepository<ListaTarefas, String> {
}
