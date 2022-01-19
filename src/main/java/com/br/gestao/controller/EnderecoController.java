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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.gestao.dto.EnderecoDto;
import com.br.gestao.form.AtualizacaoEnderecoForm;
import com.br.gestao.form.EnderecoForm;
import com.br.gestao.model.Endereco;
import com.br.gestao.repository.EnderecoRepository;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	EnderecoRepository enderecoRepository;

	@GetMapping
	@Cacheable(value = "listaDeEndereco")
	public Page<EnderecoDto> lista(
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {
		Page<Endereco> endereco = enderecoRepository.findAll(paginacao);
		return EnderecoDto.converter(endereco);

	}
	@PostMapping
	@Transactional
	@CacheEvict(value = "listaDeEndereco", allEntries = true)
	public ResponseEntity<EnderecoDto> cadastrar(@RequestBody @Valid EnderecoForm form, UriComponentsBuilder uriBuilder){
		Endereco endereco = form.converter();
		enderecoRepository.save(endereco);
		
		URI uri = uriBuilder.path("/despesas/{id}").buildAndExpand(endereco.getId()).toUri();
		return ResponseEntity.created(uri).body(new EnderecoDto(endereco));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EnderecoDto> detalhar(@PathVariable Integer id){
		Optional<Endereco> endereco = enderecoRepository.findById(id);
		if(endereco.isPresent()) {
			return ResponseEntity.ok(new EnderecoDto(endereco.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeEndereco", allEntries = true)
	public ResponseEntity<EnderecoDto> deletar(@PathVariable Integer id){
		Optional<Endereco> endereco = enderecoRepository.findById(id);
		if(endereco.isPresent()) {
			enderecoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<EnderecoDto> atualizar(@PathVariable Integer id,
			@RequestBody @Valid AtualizacaoEnderecoForm form) {
		Optional<Endereco> enderecoAtt = enderecoRepository.findById(id);
		if (enderecoAtt.isPresent()) {
			Endereco endereco = form.atualizar(id, enderecoRepository);
			return ResponseEntity.ok(new EnderecoDto(endereco));
		}
		return ResponseEntity.notFound().build();
	}
}
