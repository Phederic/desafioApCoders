package com.br.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.gestao.model.Inquilinos;

@Repository
public interface InquilinosRepository extends JpaRepository<Inquilinos, Integer>{
	

}
