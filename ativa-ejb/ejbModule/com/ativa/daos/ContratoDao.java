package com.ativa.daos;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.ativa.entidades.Contrato;
import com.ativa.entidades.Tomador;
import com.ativa.util.HibernateUtils;

public class ContratoDao {

	private static ContratoDao instance;

	private Set<Contrato> mock = new HashSet<Contrato>();

	public static ContratoDao getInstance() {
		if (instance == null) {
			instance = new ContratoDao();
		}
		return instance;
	}

	private ContratoDao() {
	}

	public void salvarContrato(Contrato contrato){
		mock.add(contrato);
	}
	
	public Contrato buscarContratoPorTomador(Tomador tomador){
		for (Contrato contrato : mock) {
//			if(contrato.getProposta().getTomador().equals(tomador))
//				return contrato;
		}
		return null;
	}
}
