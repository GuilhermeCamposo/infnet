package com.ativa.interfaces;

import java.io.Serializable;
import java.util.List;

import com.ativa.entidades.Proposta;
import com.ativa.entidades.Tomador;

public interface IEmprestimo extends Serializable {
	
	
	public void solicitarEmprestimo(Proposta proposta) throws Exception;
	
	public void solicitarRefinanciamento(Proposta proposta) throws Exception;

	public List<Proposta> buscarStatusPropostaPorCliente(Tomador tomador) throws Exception ;
	
	public void mocks();
}
