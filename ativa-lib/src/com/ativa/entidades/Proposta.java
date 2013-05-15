package com.ativa.entidades;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Proposta implements Serializable {

	private static final long serialVersionUID = -6302617285803854024L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "num_prop")
	private long numeroProposta;

	@Column(name = "val_emprestimo")
	private double valorEmprestimo;

	@Column(name = "num_parcelas")
	private int numeroParcelas;

	@Enumerated(EnumType.STRING)
	private TipoPagemento tipoPagamento;

	@ManyToOne
	@JoinColumn(name = "plano_emprestimo")
	private PlanoEmprestimo planoEmprestimo;

	@ManyToOne
	private Corretor corretor;

	@ManyToOne
	private Tomador tomador;

	@Enumerated(EnumType.STRING)
	private StatusAtiva statusAtiva;

	@Column(name = "data_deposito")
	private Timestamp dataDeposito;

	@Column(name = "status_financeira")
	private String statusFinanceira;

	@Column(name = "protocolo_entrada")
	private String protocoloEntrada;



	public Tomador getTomador() {
		return tomador;
	}

	public void setTomador(Tomador tomador) {
		this.tomador = tomador;
	}

	public StatusAtiva getStatusAtiva() {
		return statusAtiva;
	}

	public void setStatusAtiva(StatusAtiva statusAtiva) {
		this.statusAtiva = statusAtiva;
	}

	public Timestamp getDataDeposito() {
		return dataDeposito;
	}

	public void setDataDeposito(Timestamp dataDeposito) {
		this.dataDeposito = dataDeposito;
	}

	public String getStatusFinanceira() {
		return statusFinanceira;
	}

	public void setStatusFinanceira(String statusFinanceira) {
		this.statusFinanceira = statusFinanceira;
	}

	public String getProtocoloEntrada() {
		return protocoloEntrada;
	}

	public void setProtocoloEntrada(String protocoloEntrada) {
		this.protocoloEntrada = protocoloEntrada;
	}

	public Corretor getCorretor() {
		return corretor;
	}

	public void setCorretor(Corretor corretor) {
		this.corretor = corretor;
	}

	public double getValorEmprestimo() {
		return valorEmprestimo;
	}

	public void setValorEmprestimo(double valorEmprestimo) {
		this.valorEmprestimo = valorEmprestimo;
	}

	public int getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(int numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}

	public TipoPagemento getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(TipoPagemento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public PlanoEmprestimo getPlanoEmprestimo() {
		return planoEmprestimo;
	}

	public void setPlanoEmprestimo(PlanoEmprestimo planoEmprestimo) {
		this.planoEmprestimo = planoEmprestimo;
	}

	public long getNumeroProposta() {
		return numeroProposta;
	}

	public void setNumeroProposta(long numeroProposta) {
		this.numeroProposta = numeroProposta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (numeroProposta ^ (numeroProposta >>> 32));
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
		Proposta other = (Proposta) obj;
		if (numeroProposta != other.numeroProposta)
			return false;
		return true;
	}

}
