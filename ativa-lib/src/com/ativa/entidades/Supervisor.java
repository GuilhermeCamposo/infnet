package com.ativa.entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue(value="supervisor")
public class Supervisor extends Funcionario {

	private static final long serialVersionUID = -7123866329507180939L;

	private String divisao;

	public String getDivisao() {
		return divisao;
	}

	public void setDivisao(String divisao) {
		this.divisao = divisao;
	}
	
	
	
}
