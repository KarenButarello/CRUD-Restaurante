package com.algaworks.algafood.service;

import com.algaworks.algafood.exception.EntidadeEmUsoException;
import com.algaworks.algafood.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.model.Cidade;
import com.algaworks.algafood.repository.CidadeRepository;
import com.algaworks.algafood.repository.EstadoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repository;

    @Autowired
    private EstadoRepository estadoRepository;

    public ResponseEntity<Cidade> buscarPeloId(Long id) {
        var cidade = repository.buscar(id);
        if (cidade != null){
            return ResponseEntity.ok(cidade);
        }
        return ResponseEntity.notFound().build();
    }

    public List<Cidade> listar() {
        return repository.listar();
    }

    public Cidade cadastrarCidade(Cidade cidade) {
        Long estadoId = cidade.getEstadoId().getId();
        var estado = estadoRepository.buscar(estadoId);

        if (estado == null) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe cadastro de estado com código %d", estadoId));
        }

        cidade.setEstadoId(estado);
        return repository.salvar(cidade);
    }

    public ResponseEntity<Cidade> atualizarCidade(Long id, Cidade cidade) {
        var cidadeAtual = repository.buscar(id);
        cidadeAtual.setNome(cidade.getNome());

        if(cidadeAtual != null){
            BeanUtils.copyProperties(cidade, cidadeAtual, "id");
            cidadeAtual = repository.buscar(id);
            return ResponseEntity.ok(repository.salvar(cidadeAtual));
        }
        return ResponseEntity.notFound().build();
    }

    public void deletar(Long cidadeId) {
        try {
            repository.remover(cidadeId);

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe um cadastro de cidade com código %d", cidadeId));

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format("Cidade de código %d não pode ser removida, pois está em uso", cidadeId));
        }
    }
}
