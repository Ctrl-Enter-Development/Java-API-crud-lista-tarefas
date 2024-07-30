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
 