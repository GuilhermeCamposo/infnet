package com.infnet.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Init;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class MeuSingleton {

	private int estado;
	
	@PostConstruct
	public void init(){
		estado = -99;
	}
	
	public int getEstado() {
		return estado;
	}
	
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
}
