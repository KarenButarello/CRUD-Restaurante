package com.algaworks.algafood.controller;

import com.algaworks.algafood.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.model.Cidade;
import com.algaworks.algafood.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody Cidade cidade) {
        try {
            cidade = service.cadastrarCidade(cidade);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(cidade);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cidade> atualizarCidade(@PathVariable Long id, @RequestBody Cidade cidade) {
        return service.atualizarCidade(id, cidade);
    }

    @DeleteMapping
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
