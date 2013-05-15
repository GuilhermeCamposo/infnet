package com.ativa.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Contrato implements Serializable {

	private static final long serialVersionUID = -7006870931437392915L;

	@EmbeddedId
	private ContratoPK pk;

	private boolean ativo;

	@Column(name = "refinanciavel")
	private boolean refinanciavel;

	public ContratoPK getPk() {
		return pk;
	}

	public void setPk(ContratoPK pk) {
		this.pk = pk;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public boolean isRefinanciavel() {
		return refinanciavel;
	}

	public void setRefinanciavel(boolean refinanciavel) {
		this.refinanciavel = refinanciavel;
	}

}
