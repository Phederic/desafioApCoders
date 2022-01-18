package com.br.gestao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.gestao.dto.DespesasDaUnidadeDto;
import com.br.gestao.model.DespesasDaUnidade;
import com.br.gestao.model.Unidades;
import com.br.gestao.repository.DespesasDaUnidadeRepository;

@RestController
@RequestMapping("/despesas")
public class DespesasDaUnidadeController {
	
	@Autowired
	DespesasDaUnidadeRepository despesasDaUnidadeRepository;
	
	
	@GetMapping
	@Cacheable(value = "listaDeDespesas")
	public Page<DespesasDaUnidadeDto> lista(
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao, Unidades unidades){
			Page<DespesasDaUnidade> despesas = despesasDaUnidadeRepository.findAll(paginacao);
			return DespesasDaUnidadeDto.converter(despesas);
	
	}
	
	
}
