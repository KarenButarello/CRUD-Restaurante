package com.algaworks.algafood.service;

import com.algaworks.algafood.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.model.Cozinha;
import com.algaworks.algafood.model.Restaurante;
import com.algaworks.algafood.repository.CozinhaRepository;
import com.algaworks.algafood.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository repository;

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public List<Restaurante> buscarTodos() {
        return repository.listar();
    }

    public ResponseEntity<Restaurante> buscarPorId(Long id){
        var restaurante = repository.buscar(id);

        if(restaurante != null){
            return ResponseEntity.ok(restaurante);
        }
        return ResponseEntity.notFound().build();
    }

    public Restaurante cadastrar(Restaurante restaurante) {
        var cozinhaId = restaurante.getCozinhaId().getId();
        var cozinha = cozinhaRepository.buscar(cozinhaId);

        if (cozinha == null) {
            throw new EntidadeNaoEncontradaException(String.format("Não existe cadastro de cozinha com o id %d", cozinhaId));
        }

        restaurante.setCozinhaId(cozinha);

        return repository.salvar(restaurante);
    }

    public Restaurante salvar(Restaurante restaurante) {
        return repository.salvar(restaurante);
    }
}
