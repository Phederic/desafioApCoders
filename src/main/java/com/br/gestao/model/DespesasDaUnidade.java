package com.br.gestao.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DespesasDaUnidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private BigDecimal valor;
	private LocalDate vencimentoFatura;
	@Enumerated(EnumType.STRING)
	private StatusPagamento statusPagamento;
	@OneToOne(cascade=CascadeType.PERSIST)
	private Unidades unidades;

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

	public StatusPagamento getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(StatusPagamento statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public Unidades getUnidades() {
		return unidades;
	}

	public void setUnidades(Unidades unidades) {
		this.unidades = unidades;
	}

	public DespesasDaUnidade(Integer id, String descricao, BigDecimal valor, LocalDate vencimentoFatura,
			StatusPagamento statusPagamento, Unidades unidades) {
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.vencimentoFatura = vencimentoFatura;
		this.statusPagamento = statusPagamento;
		this.unidades = unidades;
	}

}
