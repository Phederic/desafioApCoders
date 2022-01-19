package com.br.gestao.form;

import com.br.gestao.model.Endereco;
import com.br.gestao.repository.EnderecoRepository;

public class AtualizacaoEnderecoForm {

	private Integer id;
	private String estado;
	private String cidade;
	private String cep;
	private String bairro;
	private String rua;
	private String numero;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Endereco atualizar(Integer id, EnderecoRepository enderecoRepository) {
		Endereco endereco = enderecoRepository.getById(id);
		endereco.setBairro(this.bairro);
		endereco.setCep(this.cep);
		endereco.setCidade(this.cidade);
		endereco.setEstado(this.estado);
		endereco.setNumero(this.numero);
		endereco.setRua(this.rua);
		return endereco;
	}

}
