package com.br.gestao.form;

import com.br.gestao.model.Inquilinos;
import com.br.gestao.model.Sexo;
import com.br.gestao.repository.InquilinosRepository;

public class AtualizacaoInquilinosForm {

	private Integer id;
	private String nome;
	private String idade;
	private Sexo sexo;
	private String telefone;
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Inquilinos atualizar(Integer id, InquilinosRepository inquilinosRepository) {
		Inquilinos inquilinos = inquilinosRepository.getById(id);
		inquilinos.setEmail(this.email);
		inquilinos.setIdade(this.idade);
		inquilinos.setNome(this.nome);
		inquilinos.setSexo(this.sexo);
		inquilinos.setTelefone(this.telefone);
		return inquilinos;
		
	}
	
}
