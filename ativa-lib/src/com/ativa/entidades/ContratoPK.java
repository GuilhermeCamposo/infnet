package com.ativa.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;

@Embeddable
public class ContratoPK implements Serializable {
	
	private static final long serialVersionUID = -3948630907303313231L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="num_contrato")
	private long numeroContrato;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Proposta proposta;

	public long getNumeroContrato() {
		return numeroContrato;
	}

	public void setNumeroContrato(long numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	public Proposta getProposta() {
		return proposta;
	}

	public void setProposta(Proposta proposta) {
		this.proposta = proposta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (numeroContrato ^ (numeroContrato >>> 32));
		result = prime * result
				+ ((proposta == null) ? 0 : proposta.hashCode());
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
		ContratoPK other = (ContratoPK) obj;
		if (numeroContrato != other.numeroContrato)
			return false;
		if (proposta == null) {
			if (other.proposta != null)
				return false;
		} else if (!proposta.equals(other.proposta))
			return false;
		return true;
	}
	

	

}
