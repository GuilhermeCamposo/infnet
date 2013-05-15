package com.ativa.daos;

import java.util.HashSet;
import java.util.Set;

import com.ativa.entidades.Tomador;

public class TomadorDao {
	
	private static TomadorDao instance;
	
	private Set<Tomador> mock = new HashSet<Tomador>();
	
	public static TomadorDao getInstance() {
		if(instance == null){
			instance = new TomadorDao();
		}
		return instance;
	}
	
	private TomadorDao(){}
	
	public void salvarTomador(Tomador tomador){
		mock.add(tomador);
	}

}
