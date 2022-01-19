package com.br.gestao.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.br.gestao.model.DespesasDaUnidade;
import com.br.gestao.model.StatusPagamento;
import com.br.gestao.model.Unidades;
import com.br.gestao.repository.DespesasDaUnidadeRepository;

public class AtualizacaoDespesaDeUnidadeForm {

	private Integer id;
	private String descricao;
	private BigDecimal valor;
	private LocalDate vencimentoFatura;
	private StatusPagamento statusPagamento;
	private Unidades unidades;

	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public LocalDate getVencimentoFatura() {
		return vencimentoFatura;
	}

	public StatusPagamento getStatusPagamento() {
		return statusPagamento;
	}

	public Unidades getUnidades() {
		return unidades;
	}

	public DespesasDaUnidade atualizar(Integer id, DespesasDaUnidadeRepository despesasDaUnidadeRepository) {
		DespesasDaUnidade despesas = despesasDaUnidadeRepository.getById(id);
		despesas.setDescricao(this.descricao);
		despesas.setStatusPagamento(this.statusPagamento);
		despesas.setVencimentoFatura(this.vencimentoFatura);
		despesas.setValor(this.valor);
		despesas.setUnidades(this.unidades);
		return despesas;
	}

}
