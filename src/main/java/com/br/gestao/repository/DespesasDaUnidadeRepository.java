package com.br.gestao.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.gestao.model.DespesasDaUnidade;

@Repository
public interface DespesasDaUnidadeRepository extends JpaRepository<DespesasDaUnidade, Integer> {

//	
//	Page<DespesasDaUnidade> findByUnidades(Unidades unidades, Pageable paginacao);
//	Page<DespesasDaUnidade> findByVencimentoFaturaGreaterThan(LocalDate dataHoje, Pageable paginacao);
	
}
