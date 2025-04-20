package com.algaworks.algafood.service;

import com.algaworks.algafood.exception.EntidadeEmUsoException;
import com.algaworks.algafood.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.model.Estado;
import com.algaworks.algafood.repository.EstadoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository repository;

    public ResponseEntity<Estado> buscarPorId(Long id) {
        var estado = repository.buscar(id);

        if(estado != null){
            return ResponseEntity.ok(estado);
        }
        return ResponseEntity.notFound().build();
    }

    public List<Estado> buscarTodos() {
        return repository.listar();
    }

    public Estado cadastrarEstado(Estado estado) {
        return repository.salvar(estado);
    }

    public ResponseEntity<Estado> atualizarEstado(Long id, Estado estado) {
        var estadoAtual = repository.buscar(id);

        if (estadoAtual != null) {
            BeanUtils.copyProperties(estado, estadoAtual, "id");

            estadoAtual = repository.salvar(estadoAtual);
            return ResponseEntity.ok(estadoAtual);
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> deletar(Long estadoId) {
        try {
            repository.remover(estadoId);
            return ResponseEntity.noContent().build();

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();

        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }
}
