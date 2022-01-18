package com.br.gestao.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.domain.Page;

import com.br.gestao.model.DespesasDaUnidade;
import com.br.gestao.model.StatusPagamento;
import com.br.gestao.model.Unidades;

public class DespesasDaUnidadeDto {

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
	public Unidades getUnidades() {
		return unidades;
	}
	public void setUnidades(Unidades unidades) {
		this.unidades = unidades;
	}
	
	public DespesasDaUnidadeDto(DespesasDaUnidade despesasDaUnidade) {
		this.descricao = despesasDaUnidade.getDescricao();
		this.id = despesasDaUnidade.getId();
		this.statusPagamento = despesasDaUnidade.getStatusPagamento();
		this.unidades = despesasDaUnidade.getUnidades();
		this.valor = despesasDaUnidade.getValor();
		this.vencimentoFatura = despesasDaUnidade.getVencimentoFatura();
	}
	
	public static Page<DespesasDaUnidadeDto> converter(Page<DespesasDaUnidade> despesasDaUnidade){
		return despesasDaUnidade.map(DespesasDaUnidadeDto::new);
	}
	
}
