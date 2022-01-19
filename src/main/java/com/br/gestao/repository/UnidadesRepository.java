package com.br.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.gestao.model.Unidades;


@Repository
public interface UnidadesRepository extends JpaRepository<Unidades, Integer> {

}
