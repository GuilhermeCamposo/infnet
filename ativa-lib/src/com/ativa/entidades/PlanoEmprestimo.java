package com.ativa.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PlanoEmprestimo  implements Serializable{

	private static final long serialVersionUID = -1556341115959582261L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nome_plano")
	private String  nomePlano;
	
	@Column(name="min_parcelas")
	private int minParcelas;
	
	@Column(name="max_parcelas")
	private int maxParcelas;
	
	@Column(name="taxa_anual_juros")
	private float taxaAnualJuros;
	
	@Column(name="percentual_comissao")
	private float percentualComissao;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomePlano() {
		return nomePlano;
	}
	public void setNomePlano(String nomePlano) {
		this.nomePlano = nomePlano;
	}
	public int getMinParcelas() {
		return minParcelas;
	}
	public void setMinParcelas(int minParcelas) {
		this.minParcelas = minParcelas;
	}
	public int getMaxParcelas() {
		return maxParcelas;
	}
	public void setMaxParcelas(int maxParcelas) {
		this.maxParcelas = maxParcelas;
	}
	public float getTaxaAnualJuros() {
		return taxaAnualJuros;
	}
	public void setTaxaAnualJuros(float taxaAnualJuros) {
		this.taxaAnualJuros = taxaAnualJuros;
	}
	public float getPercentualComissao() {
		return percentualComissao;
	}
	public void setPercentualComissao(float percentualComissao) {
		this.percentualComissao = percentualComissao;
	}
	
	
	
	
}
