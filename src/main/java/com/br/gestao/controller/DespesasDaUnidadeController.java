package com.br.gestao.controller;

import java.net.URI;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.gestao.dto.DespesasDaUnidadeDto;
import com.br.gestao.form.DespesasDaUnidadeForm;
import com.br.gestao.model.DespesasDaUnidade;
import com.br.gestao.repository.DespesasDaUnidadeRepository;

@RestController
@RequestMapping("/despesas")
public class DespesasDaUnidadeController {
	
	@Autowired
	DespesasDaUnidadeRepository despesasDaUnidadeRepository;
	
	
	@GetMapping
	@Cacheable(value = "listaDeDespesas")
	public Page<DespesasDaUnidadeDto> lista(
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao){
			Page<DespesasDaUnidade> despesas = despesasDaUnidadeRepository.findAll(paginacao);
			return DespesasDaUnidadeDto.converter(despesas);
	
	}
	
	@PostMapping
	@Transactional
	@CacheEvict(value = "listaDeDespesas", allEntries = true)
	public ResponseEntity<DespesasDaUnidadeDto> cadastrar(@RequestBody @Valid DespesasDaUnidadeForm form, UriComponentsBuilder uriBuilder){
		DespesasDaUnidade despesas = form.converter();
		despesasDaUnidadeRepository.save(despesas);
		
		URI uri = uriBuilder.path("/despesas/{id}").buildAndExpand(despesas.getId()).toUri();
		return ResponseEntity.created(uri).body(new DespesasDaUnidadeDto(despesas));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DespesasDaUnidadeDto> detalhar(@PathVariable Integer id){
		Optional<DespesasDaUnidade> despesas = despesasDaUnidadeRepository.findById(id);
		if(despesas.isPresent()) {
			return ResponseEntity.ok(new DespesasDaUnidadeDto(despesas.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeDespesas", allEntries = true)
	public ResponseEntity<DespesasDaUnidadeDto> deletar(@PathVariable Integer id){
		Optional<DespesasDaUnidade> despesas = despesasDaUnidadeRepository.findById(id);
		if(despesas.isPresent()) {
			despesasDaUnidadeRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
