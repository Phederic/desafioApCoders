package com.br.gestao.dto;

import org.springframework.data.domain.Page;

import com.br.gestao.model.Endereco;

public class EnderecoDto {

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

	public EnderecoDto(Endereco endereco) {
		this.id = endereco.getId();
		this.bairro = endereco.getBairro();
		this.cep = endereco.getCep();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();

	}

	public static Page<EnderecoDto> converter(Page<Endereco> endereco) {
		return endereco.map(EnderecoDto::new);
	}

}
