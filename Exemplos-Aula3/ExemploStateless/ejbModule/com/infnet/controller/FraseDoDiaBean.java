package com.infnet.controller;

import javax.annotation.PostConstruct;
import javax.ejb.Init;
import javax.ejb.Stateless;


@Stateless
public class FraseDoDiaBean implements FraseDoDia{

	@Init
	public void inicializar(){
		System.out.println("Inicializando...");
	}
	
	@PostConstruct
	public void criou(){
		System.out.println("Criou objeto...");
	}
	
    @Override
    public String pegarFrase() {
    	return "Lorem Ipsum";
    }

}
