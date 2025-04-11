package com.algaworks.algafood.repository;

import com.algaworks.algafood.model.Permissao;

import java.util.List;

public interface PermissaoRepository {

    Permissao buscar(Long id);

    List<Permissao> listar();

    Permissao salvar(Permissao permissao);

    void remover(Permissao permissao);
}
