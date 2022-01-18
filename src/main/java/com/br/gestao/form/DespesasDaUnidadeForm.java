package com.br.gestao.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.br.gestao.model.DespesasDaUnidade;
import com.br.gestao.model.StatusPagamento;
import com.br.gestao.model.Unidades;

public class DespesasDaUnidadeForm {

	private Integer id;
	private String descricao;
	private BigDecimal valor;
	private LocalDate vencimentoFatura;
	private StatusPagamento statusPagamento;
	private Unidades unidades;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getVencimentoFatura() {
		return vencimentoFatura;
	}

	public void setVencimentoFatura(LocalDate vencimentoFatura) {
		this.vencimentoFatura = vencimentoFatura;
	}

	public StatusPagamento getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(StatusPagamento statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public DespesasDaUnidade converter() {
		return new DespesasDaUnidade(id, descricao, valor, vencimentoFatura, statusPagamento, unidades);
	}

}
