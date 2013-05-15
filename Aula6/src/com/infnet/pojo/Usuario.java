package com.infnet.pojo;

import java.io.Serializable;

public class Usuario implements Serializable{
	private static final long serialVersionUID = 4915871382715788275L;
	private final String nome;
	
	public Usuario(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
}
