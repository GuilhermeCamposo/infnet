package com.ativa.entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue(value="gerente")
public class Gerente extends Funcionario {

	private static final long serialVersionUID = -2613120227274703714L;

	private boolean permissaoAnalise;

	public boolean isPermissaoAnalise() {
		return permissaoAnalise;
	}

	public void setPermissaoAnalise(boolean permissaoAnalise) {
		this.permissaoAnalise = permissaoAnalise;
	}
	
	
	
	
}
