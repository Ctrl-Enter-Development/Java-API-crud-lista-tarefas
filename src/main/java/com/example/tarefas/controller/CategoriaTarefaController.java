package com.example.tarefas.controller;

import com.example.tarefas.model.CategoriaTarefa;
import com.example.tarefas.repository.CategoriaTarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoriaTarefas")
public class CategoriaTarefaController {
    
    @Autowired
    private CategoriaTarefaRepository repository;
    
    @GetMapping
    public List<CategoriaTarefa> getAllCategoriaTarefas() {
        return repository.findAll();
    }
    
    @PostMapping
    public CategoriaTarefa createCategoriaTarefa(@RequestBody CategoriaTarefa categoriaTarefa) {
        return repository.save(categoriaTarefa);
    }
    
    @GetMapping("/{id}")
    public CategoriaTarefa getCategoriaTarefaById(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }
    
    @PutMapping("/{id}")
    public CategoriaTarefa updateCategoriaTarefa(@PathVariable String id, @RequestBody CategoriaTarefa categoriaTarefa) {
        categoriaTarefa.setId(id);
        return repository.save(categoriaTarefa);
    }
    
    @DeleteMapping("/{id}")
    public void deleteCategoriaTarefa(@PathVariable String id) {
        repository.deleteById(id);
    }
}
