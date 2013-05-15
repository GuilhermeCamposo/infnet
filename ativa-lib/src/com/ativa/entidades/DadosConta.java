package com.ativa.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DadosConta implements Serializable {

	private static final long serialVersionUID = 2140581319120995955L;

	private String agencia, conta;
	
	@Column(name = "num_banco")
	private String numBanco;

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumBanco() {
		return numBanco;
	}

	public void setNumBanco(String numBanco) {
		this.numBanco = numBanco;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

}
