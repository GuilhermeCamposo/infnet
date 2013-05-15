package com.ativa.entidades;

import java.io.Serializable;
import java.sql.Timestamp;

public class PropostaWorkflow implements Serializable {
	
	private long id;
	private Proposta proposta;
	private Funcionario funcionario;
	private Timestamp   data;
	private StatusAtiva status;
	
	public Proposta getProposta() {
		return proposta;
	}
	public void setProposta(Proposta proposta) {
		this.proposta = proposta;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Timestamp getData() {
		return data;
	}
	public void setData(Timestamp data) {
		this.data = data;
	}
	public StatusAtiva getStatus() {
		return status;
	}
	public void setStatus(StatusAtiva status) {
		this.status = status;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	

}
