package com.algaworks.algafood.repository;

import com.algaworks.algafood.model.Estado;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EstadoRepository {

    List<Estado> listar();

    Estado buscar(Long id);

    Estado salvar(Estado estado);

    void remover(Long id);
}
