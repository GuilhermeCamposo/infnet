package com.ativa.interfaces;

import java.io.Serializable;
import java.util.List;

import com.ativa.entidades.Gerente;
import com.ativa.entidades.Proposta;

public interface IAnaliseProposta extends Serializable{
	
	public List<Proposta> buscarPropostasParaAnalise(Gerente gerente) throws Exception;
	
	public void rejeitarProposta(Proposta proposta, Gerente gerente);
	
	public void preAprovarProposta(Proposta proposta, Gerente gerente);

}
