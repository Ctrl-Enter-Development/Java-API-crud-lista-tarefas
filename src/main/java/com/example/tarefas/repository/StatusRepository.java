package com.example.tarefas.repository;

import com.example.tarefas.model.Status;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StatusRepository extends MongoRepository<Status, String> {
}
