package com.example.tarefas.controller;

import com.example.tarefas.model.*;
import com.example.tarefas.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/listaTarefas")
public class ListaTarefasController {

    @Autowired
    private ListaTarefasRepository listaTarefasRepository;

    @Autowired
    private PrioridadeRepository prioridadeRepository;

    @Autowired
    private CategoriaTarefaRepository categoriaTarefaRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private ResponsavelRepository responsavelRepository;

    @GetMapping
    public List<ListaTarefas> getAllListaTarefas() {
        return listaTarefasRepository.findAll();
    }

    @PostMapping
    public ListaTarefas createListaTarefas(@RequestBody ListaTarefas listaTarefas) {
        if (listaTarefas.getPrioridade() != null && listaTarefas.getPrioridade().getId() != null) {
            Optional<Prioridade> prioridade = prioridadeRepository.findById(listaTarefas.getPrioridade().getId());
            prioridade.ifPresent(listaTarefas::setPrioridade);
        }

        if (listaTarefas.getCategoriaTarefa() != null && listaTarefas.getCategoriaTarefa().getId() != null) {
            Optional<CategoriaTarefa> categoriaTarefa = categoriaTarefaRepository.findById(listaTarefas.getCategoriaTarefa().getId());
            categoriaTarefa.ifPresent(listaTarefas::setCategoriaTarefa);
        }

        if (listaTarefas.getStatus() != null && listaTarefas.getStatus().getId() != null) {
            Optional<Status> status = statusRepository.findById(listaTarefas.getStatus().getId());
            status.ifPresent(listaTarefas::setStatus);
        }

        if (listaTarefas.getResponsavel() != null && listaTarefas.getResponsavel().getId() != null) {
            Optional<Responsavel> responsavel = responsavelRepository.findById(listaTarefas.getResponsavel().getId());
            responsavel.ifPresent(listaTarefas::setResponsavel);
        }

        return listaTarefasRepository.save(listaTarefas);
    }

    @GetMapping("/{id}")
    public ListaTarefas getListaTarefasById(@PathVariable String id) {
        return listaTarefasRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public ListaTarefas updateListaTarefas(@PathVariable String id, @RequestBody ListaTarefas listaTarefas) {
        listaTarefas.setId(id);

        if (listaTarefas.getPrioridade() != null && listaTarefas.getPrioridade().getId() != null) {
            Optional<Prioridade> prioridade = prioridadeRepository.findById(listaTarefas.getPrioridade().getId());
            prioridade.ifPresent(listaTarefas::setPrioridade);
        }

        if (listaTarefas.getCategoriaTarefa() != null && listaTarefas.getCategoriaTarefa().getId() != null) {
            Optional<CategoriaTarefa> categoriaTarefa = categoriaTarefaRepository.findById(listaTarefas.getCategoriaTarefa().getId());
            categoriaTarefa.ifPresent(listaTarefas::setCategoriaTarefa);
        }

        if (listaTarefas.getStatus() != null && listaTarefas.getStatus().getId() != null) {
            Optional<Status> status = statusRepository.findById(listaTarefas.getStatus().getId());
            status.ifPresent(listaTarefas::setStatus);
        }

        if (listaTarefas.getResponsavel() != null && listaTarefas.getResponsavel().getId() != null) {
            Optional<Responsavel> responsavel = responsavelRepository.findById(listaTarefas.getResponsavel().getId());
            responsavel.ifPresent(listaTarefas::setResponsavel);
        }

        return listaTarefasRepository.save(listaTarefas);
    }

    @DeleteMapping("/{id}")
    public void deleteListaTarefas(@PathVariable String id) {
        listaTarefasRepository.deleteById(id);
    }
}
