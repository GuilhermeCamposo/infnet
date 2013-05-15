package com.ativa.entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.TableGenerator;


@Entity
@TableGenerator(name = "Gerentes")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value="corretor")
public class Corretor extends Funcionario {
	
	private static final long serialVersionUID = 1228744550549130445L;
	
	private String regiao;

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	
	

}
