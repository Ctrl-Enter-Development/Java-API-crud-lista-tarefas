package com.example.tarefas.repository;

import com.example.tarefas.model.Responsavel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResponsavelRepository extends MongoRepository<Responsavel, String> {
}
