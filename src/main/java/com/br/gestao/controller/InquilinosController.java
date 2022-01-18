package com.br.gestao.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.gestao.dto.InquilinosDto;
import com.br.gestao.form.InquilinosForm;
import com.br.gestao.model.Inquilinos;
import com.br.gestao.repository.InquilinosRepository;

@RestController
@RequestMapping("/inquilinos")
public class InquilinosController {

	@Autowired
	InquilinosRepository inquilinosRepository;

	@GetMapping
	@Cacheable(value = "listaDeInquilinos")
	public Page<InquilinosDto> lista(
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {
		Page<Inquilinos> inquilinos = inquilinosRepository.findAll(paginacao);
		return InquilinosDto.converter(inquilinos);
	}
	@PostMapping
	@Transactional
	@CacheEvict(value = "listaDeInquilinos", allEntries = true)
	public ResponseEntity<InquilinosDto> cadastrar(@RequestBody @Valid InquilinosForm form, UriComponentsBuilder uriBuilder){
		Inquilinos inquilinos = form.converter();
		inquilinosRepository.save(inquilinos);
		
		URI uri = uriBuilder.path("/inquilinos/{id}").buildAndExpand(inquilinos.getId()).toUri();
		return ResponseEntity.created(uri).body(new InquilinosDto(inquilinos));
	}
}
