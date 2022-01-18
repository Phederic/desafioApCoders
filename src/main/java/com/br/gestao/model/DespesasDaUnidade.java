package com.br.gestao.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DespesasDaUnidade {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private BigDecimal valor;
	private LocalDate vencimentoFatura;
	private LocalDate statusPagamento;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DespesasDaUnidade other = (DespesasDaUnidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
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
	public LocalDate getStatusPagamento() {
		return statusPagamento;
	}
	public void setStatusPagamento(LocalDate statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	
	
	
	
}
