package com.infnet.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;

@Stateful
public class MeuStateful {

	private int numero;
	
	public int getNumero(){
		return this.numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	@PostConstruct
	public void init(){
		this.numero = -1;
	}
}
