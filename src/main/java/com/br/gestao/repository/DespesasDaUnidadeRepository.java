package com.br.gestao.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.gestao.model.DespesasDaUnidade;
import com.br.gestao.model.Unidades;

@Repository
public interface DespesasDaUnidadeRepository extends JpaRepository<DespesasDaUnidade, Integer> {

	
	Page<DespesasDaUnidade> findByUnidades(Unidades unidades, Pageable paginacao);
	Page<DespesasDaUnidade> findByVencimentoFaturaGreaterThan(LocalDate dataHoje, Pageable paginacao);
	
}
