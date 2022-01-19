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

import com.br.gestao.dto.UnidadesDto;
import com.br.gestao.form.AtualizacaoUnidadesForm;
import com.br.gestao.form.UnidadesForm;
import com.br.gestao.model.Unidades;
import com.br.gestao.repository.UnidadesRepository;

@RestController
@RequestMapping("/unidades")
public class UnidadesController {

	@Autowired
	UnidadesRepository unidadesRepository;

	@GetMapping
	@Cacheable(value = "listaDeUnidades")
	public Page<UnidadesDto> lista(
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {
		Page<Unidades> unidades = unidadesRepository.findAll(paginacao);
		return UnidadesDto.converter(unidades);

	}

	@PostMapping
	@Transactional
	@CacheEvict(value = "listaDeUnidades", allEntries = true)
	public ResponseEntity<UnidadesDto> cadastrar(@RequestBody @Valid UnidadesForm form,
			UriComponentsBuilder uriBuilder) {
		Unidades unidades = form.converter();
		unidadesRepository.save(unidades);

		URI uri = uriBuilder.path("/unidades/{id}").buildAndExpand(unidades.getId()).toUri();
		return ResponseEntity.created(uri).body(new UnidadesDto(unidades));
	}

	@GetMapping("/{id}")
	public ResponseEntity<UnidadesDto> detalhar(@PathVariable Integer id) {
		Optional<Unidades> unidades = unidadesRepository.findById(id);
		if (unidades.isPresent()) {
			return ResponseEntity.ok(new UnidadesDto(unidades.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeUnidades", allEntries = true)
	public ResponseEntity<UnidadesDto> deletar(@PathVariable Integer id) {
		Optional<Unidades> unidades = unidadesRepository.findById(id);
		if (unidades.isPresent()) {
			unidadesRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<UnidadesDto> atualizar(@PathVariable Integer id,
			@RequestBody @Valid AtualizacaoUnidadesForm form) {
		Optional<Unidades> unidadesAtt = unidadesRepository.findById(id);
		if (unidadesAtt.isPresent()) {
			Unidades unidades = form.atualizar(id, unidadesRepository);
			return ResponseEntity.ok(new UnidadesDto(unidades));
		}
		return ResponseEntity.notFound().build();
	}

}
