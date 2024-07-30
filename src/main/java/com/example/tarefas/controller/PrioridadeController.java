package com.example.tarefas.controller;

import com.example.tarefas.model.Prioridade;
import com.example.tarefas.repository.PrioridadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prioridades")
public class PrioridadeController {
    
    @Autowired
    private PrioridadeRepository repository;
    
    @GetMapping
    public List<Prioridade> getAllPrioridades() {
        return repository.findAll();
    }
    
    @PostMapping
    public Prioridade createPrioridade(@RequestBody Prioridade prioridade) {
        return repository.save(prioridade);
    }
    
    @GetMapping("/{id}")
    public Prioridade getPrioridadeById(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }
    
    @PutMapping("/{id}")
    public Prioridade updatePrioridade(@PathVariable String id, @RequestBody Prioridade prioridade) {
        prioridade.setId(id);
        return repository.save(prioridade);
    }
    
    @DeleteMapping("/{id}")
    public void deletePrioridade(@PathVariable String id) {
        repository.deleteById(id);
    }
}
