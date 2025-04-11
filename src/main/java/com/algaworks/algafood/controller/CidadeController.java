package com.algaworks.algafood.controller;

import com.algaworks.algafood.model.Cidade;
import com.algaworks.algafood.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeService service;

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> buscar(@PathVariable Long id) {
        return service.buscarPeloId(id);
    }

    @GetMapping
    public List<Cidade> listar() {
        return service.listar();
    }

    @DeleteMapping
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
