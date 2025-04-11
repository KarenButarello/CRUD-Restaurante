package com.algaworks.algafood.service;

import com.algaworks.algafood.exception.EntidadeEmUsoException;
import com.algaworks.algafood.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.model.Estado;
import com.algaworks.algafood.repository.EstadoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
        estadoAtual.setNome(estado.getNome());

        if (estadoAtual != null) {
            BeanUtils.copyProperties(estado, estadoAtual, "id");

            estadoAtual = repository.buscar(id);
            return ResponseEntity.ok(repository.salvar(estadoAtual));
        }
        return ResponseEntity.notFound().build();
    }

    public void deletar(Long id) {
        try {
            repository.remover(id);
        } catch (EntidadeEmUsoException e) {
            throw new EntidadeEmUsoException(String
                    .format("Estado não pode ser apagado pois existe cidade atralado a ele."));

        } catch (EntidadeNaoEncontradaException e) {
            throw new EntidadeNaoEncontradaException("Estado não encontrado.");
        }

    }
}
