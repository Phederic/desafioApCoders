package com.br.gestao.dto;

import org.springframework.data.domain.Page;

import com.br.gestao.model.Endereco;
import com.br.gestao.model.Unidades;

public class UnidadesDto {

	private Integer id;
	private String identificacao;
	private String propietario;
	private String condominio;
	private Endereco endereco;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public String getCondominio() {
		return condominio;
	}

	public void setCondominio(String condominio) {
		this.condominio = condominio;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public UnidadesDto(Unidades unidades) {
		this.condominio = unidades.getCondominio();
		this.endereco = unidades.getEndereco();
		this.id = unidades.getId();
		this.identificacao = unidades.getIdentificacao();
		this.propietario = unidades.getPropietario();
	}
	
	public static Page<UnidadesDto> converter(Page<Unidades> unidades){
		return unidades.map(UnidadesDto::new);
		
	}
}
