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

import com.br.gestao.dto.InquilinosDto;
import com.br.gestao.model.Inquilinos;
import com.br.gestao.repository.InquilinosRepository;

@RestController
@RequestMapping("/inquilinos")
public class InquilinosController {

	@Autowired
	InquilinosRepository inquilinosRepository;

	
	
	@GetMapping
	@Cacheable(value = "listaDeInquilinos")
	public Page<InquilinosDto> lista(@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao){
		Page<Inquilinos> inquilinos = inquilinosRepository.findAll(paginacao);
		return InquilinosDto.converter(inquilinos);
	}
}
