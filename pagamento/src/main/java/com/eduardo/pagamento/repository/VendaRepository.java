package com.eduardo.pagamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardo.pagamento.entity.Venda;
import com.eduardo.pagamento.entity.data.vo.VendaVO;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

}
