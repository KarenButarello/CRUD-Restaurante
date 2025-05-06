package com.algaworks.algafood.repository;

import com.algaworks.algafood.model.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {

}
