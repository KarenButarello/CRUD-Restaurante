package com.algaworks.algafood.repository;

import com.algaworks.algafood.model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

}
