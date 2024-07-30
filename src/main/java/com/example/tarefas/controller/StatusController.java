package com.example.tarefas.controller;

import com.example.tarefas.model.Status;
import com.example.tarefas.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {
    
    @Autowired
    private StatusRepository repository;
    
    @GetMapping
    public List<Status> getAllStatus() {
        return repository.findAll();
    }
    
    @PostMapping
    public Status createStatus(@RequestBody Status status) {
        return repository.save(status);
    }
    
    @GetMapping("/{id}")
    public Status getStatusById(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }
    
    @PutMapping("/{id}")
    public Status updateStatus(@PathVariable String id, @RequestBody Status status) {
        status.setId(id);
        return repository.save(status);
    }
    
    @DeleteMapping("/{id}")
    public void deleteStatus(@PathVariable String id) {
        repository.deleteById(id);
    }
}
