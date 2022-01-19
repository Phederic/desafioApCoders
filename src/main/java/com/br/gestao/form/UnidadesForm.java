package com.br.gestao.form;

import com.br.gestao.model.Endereco;
import com.br.gestao.model.Unidades;

public class UnidadesForm {

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

	public Unidades converter() {
		return new Unidades(id, identificacao, propietario, condominio, endereco);
	}

}
