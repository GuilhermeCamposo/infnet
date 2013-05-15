package com.ativa.daos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ativa.entidades.Proposta;
import com.ativa.entidades.StatusAtiva;
import com.ativa.entidades.Tomador;

public class PropostaDao {

	private static PropostaDao instance;

	private Set<Proposta> mock = new HashSet<Proposta>();
	
	public static PropostaDao getInstance() {
		if (instance == null) {
			instance = new PropostaDao();
		}
		return instance;
	}
	
	private PropostaDao(){}
	
	public List<Proposta> buscarPropostaEmAnalise(){
		List<Proposta> propostas = new ArrayList<Proposta>();
		
		 for (Proposta proposta : mock) {
			if (proposta.getStatusAtiva().equals(StatusAtiva.EM_ANALISE))
				propostas.add(proposta);
		}		
		 
		return propostas;
	}
	
	public void salvarProposta(Proposta proposta){
		mock.add(proposta);
	}
	
	public List<Proposta> buscarPropostaPorTomador(Tomador tomador){
		List<Proposta> propostas = new ArrayList<Proposta>();
		
		 for (Proposta proposta : mock) {
			if (proposta.getTomador().equals(tomador) && ( !proposta.getStatusAtiva().equals(StatusAtiva.PRE_APROVADA) ))
				propostas.add(proposta);
		}		
		 
		return propostas;
	}
	
}
