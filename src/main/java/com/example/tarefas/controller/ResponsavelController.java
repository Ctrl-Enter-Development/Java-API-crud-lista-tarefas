package com.example.tarefas.controller;

import com.example.tarefas.model.Responsavel;
import com.example.tarefas.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/responsaveis")
public class ResponsavelController {
    
    @Autowired
    private ResponsavelRepository repository;
    
    @GetMapping
    public List<Responsavel> getAllResponsaveis() {
        return repository.findAll();
    }
    
    @PostMapping
    public Responsavel createResponsavel(@RequestBody Responsavel responsavel) {
        return repository.save(responsavel);
    }
    
    @GetMapping("/{id}")
    public Responsavel getResponsavelById(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }
    
    @PutMapping("/{id}")
    public Responsavel updateResponsavel(@PathVariable String id, @RequestBody Responsavel responsavel) {
        responsavel.setId(id);
        return repository.save(responsavel);
    }
    
    @DeleteMapping("/{id}")
    public void deleteResponsavel(@PathVariable String id) {
        repository.deleteById(id);
    }
}
