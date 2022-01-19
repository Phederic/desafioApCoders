package com.br.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.gestao.model.Endereco;


@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
