package com.example.tarefas.controller;

import com.example.tarefas.exception.*;
import com.example.tarefas.model.*;
import com.example.tarefas.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<ListaTarefas>> getAllListaTarefas() {
        List<ListaTarefas> tarefas = listaTarefasRepository.findAll();
        return new ResponseEntity<>(tarefas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createListaTarefas(@RequestBody ListaTarefas listaTarefas) {
        try {
            if (listaTarefas.getPrioridade() != null && listaTarefas.getPrioridade().getId() != null) {
                Prioridade prioridade = prioridadeRepository.findById(listaTarefas.getPrioridade().getId())
                        .orElseThrow(() -> new PrioridadeNotFoundException("Prioridade não encontrada com o id " + listaTarefas.getPrioridade().getId()));
                listaTarefas.setPrioridade(prioridade);
            } else {
                throw new PrioridadeNotFoundException("Prioridade é obrigatória");
            }

            if (listaTarefas.getCategoriaTarefa() != null && listaTarefas.getCategoriaTarefa().getId() != null) {
                CategoriaTarefa categoriaTarefa = categoriaTarefaRepository.findById(listaTarefas.getCategoriaTarefa().getId())
                        .orElseThrow(() -> new CategoriaTarefaNotFoundException("CategoriaTarefa não encontrada com o id " + listaTarefas.getCategoriaTarefa().getId()));
                listaTarefas.setCategoriaTarefa(categoriaTarefa);
            } else {
                throw new CategoriaTarefaNotFoundException("CategoriaTarefa é obrigatória");
            }

            if (listaTarefas.getStatus() != null && listaTarefas.getStatus().getId() != null) {
                Status status = statusRepository.findById(listaTarefas.getStatus().getId())
                        .orElseThrow(() -> new StatusNotFoundException("Status não encontrado com o id " + listaTarefas.getStatus().getId()));
                listaTarefas.setStatus(status);
            } else {
                throw new StatusNotFoundException("Status é obrigatório");
            }

            if (listaTarefas.getResponsavel() != null && listaTarefas.getResponsavel().getId() != null) {
                Responsavel responsavel = responsavelRepository.findById(listaTarefas.getResponsavel().getId())
                        .orElseThrow(() -> new ResponsavelNotFoundException("Responsável não encontrado com o id " + listaTarefas.getResponsavel().getId()));
                listaTarefas.setResponsavel(responsavel);
            } else {
                throw new ResponsavelNotFoundException("Responsável é obrigatório");
            }

            ListaTarefas savedTarefa = listaTarefasRepository.save(listaTarefas);
            return new ResponseEntity<>(savedTarefa, HttpStatus.CREATED);
        } catch (PrioridadeNotFoundException | CategoriaTarefaNotFoundException | StatusNotFoundException | ResponsavelNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListaTarefas> getListaTarefasById(@PathVariable String id) {
        try {
            ListaTarefas tarefa = listaTarefasRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Tarefa não encontrada com o id " + id));
            return new ResponseEntity<>(tarefa, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateListaTarefas(@PathVariable String id, @RequestBody ListaTarefas listaTarefas) {
        try {
            listaTarefas.setId(id);

            if (listaTarefas.getPrioridade() != null && listaTarefas.getPrioridade().getId() != null) {
                Prioridade prioridade = prioridadeRepository.findById(listaTarefas.getPrioridade().getId())
                        .orElseThrow(() -> new PrioridadeNotFoundException("Prioridade não encontrada com o id " + listaTarefas.getPrioridade().getId()));
                listaTarefas.setPrioridade(prioridade);
            } else {
                throw new PrioridadeNotFoundException("Prioridade é obrigatória");
            }

            if (listaTarefas.getCategoriaTarefa() != null && listaTarefas.getCategoriaTarefa().getId() != null) {
                CategoriaTarefa categoriaTarefa = categoriaTarefaRepository.findById(listaTarefas.getCategoriaTarefa().getId())
                        .orElseThrow(() -> new CategoriaTarefaNotFoundException("CategoriaTarefa não encontrada com o id " + listaTarefas.getCategoriaTarefa().getId()));
                listaTarefas.setCategoriaTarefa(categoriaTarefa);
            } else {
                throw new CategoriaTarefaNotFoundException("CategoriaTarefa é obrigatória");
            }

            if (listaTarefas.getStatus() != null && listaTarefas.getStatus().getId() != null) {
                Status status = statusRepository.findById(listaTarefas.getStatus().getId())
                        .orElseThrow(() -> new StatusNotFoundException("Status não encontrado com o id " + listaTarefas.getStatus().getId()));
                listaTarefas.setStatus(status);
            } else {
                throw new StatusNotFoundException("Status é obrigatório");
            }

            if (listaTarefas.getResponsavel() != null && listaTarefas.getResponsavel().getId() != null) {
                Responsavel responsavel = responsavelRepository.findById(listaTarefas.getResponsavel().getId())
                        .orElseThrow(() -> new ResponsavelNotFoundException("Responsável não encontrado com o id " + listaTarefas.getResponsavel().getId()));
                listaTarefas.setResponsavel(responsavel);
            } else {
                throw new ResponsavelNotFoundException("Responsável é obrigatório");
            }

            ListaTarefas updatedTarefa = listaTarefasRepository.save(listaTarefas);
            return new ResponseEntity<>(updatedTarefa, HttpStatus.OK);
        } catch (PrioridadeNotFoundException | CategoriaTarefaNotFoundException | StatusNotFoundException | ResponsavelNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteListaTarefas(@PathVariable String id) {
        try {
            ListaTarefas tarefa = listaTarefasRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Tarefa não encontrada com o id " + id));
            listaTarefasRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
