package com.algaworks.algafood.controller;

import com.algaworks.algafood.model.Estado;
import com.algaworks.algafood.repository.EstadoRepository;
import com.algaworks.algafood.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository repository;
    @Autowired
    private EstadoService service;

    @GetMapping
    public List<Estado> buscarTodos() {
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Estado cadastrarEstado(@RequestBody Estado estado) {
        return service.cadastrarEstado(estado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> atualizarEstado(@PathVariable Long id, @RequestBody Estado estado) {
        return service.atualizarEstado(id,estado);
    }

    @DeleteMapping("/{id}")
    public void deletarEstado(@PathVariable Long id) {
        service.deletar(id);
    }
}
