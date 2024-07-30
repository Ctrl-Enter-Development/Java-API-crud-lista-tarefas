package com.example.tarefas.repository;

import com.example.tarefas.model.Prioridade;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PrioridadeRepository extends MongoRepository<Prioridade, String> {
}
