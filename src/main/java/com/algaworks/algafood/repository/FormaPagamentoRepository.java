package com.algaworks.algafood.repository;

import com.algaworks.algafood.model.FormaPagamento;

import java.util.List;

public interface FormaPagamentoRepository {

    FormaPagamento buscar(Long id);

    List<FormaPagamento> listar();

    FormaPagamento salvar(FormaPagamento formaPagamento);

    void remover(FormaPagamento formaPagamento);
}
