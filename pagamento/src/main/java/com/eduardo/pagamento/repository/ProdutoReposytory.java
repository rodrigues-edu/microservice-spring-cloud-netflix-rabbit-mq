package com.eduardo.pagamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardo.pagamento.entity.Produto;

@Repository
public interface ProdutoReposytory extends JpaRepository<Produto, Long> {

}
