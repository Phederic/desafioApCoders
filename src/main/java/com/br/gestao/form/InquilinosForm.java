package com.br.gestao.form;

import com.br.gestao.model.Inquilinos;
import com.br.gestao.model.Sexo;

public class InquilinosForm {

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

	public Inquilinos converter() {
		return new Inquilinos(id, nome, idade, sexo, telefone, email);

	}
}
