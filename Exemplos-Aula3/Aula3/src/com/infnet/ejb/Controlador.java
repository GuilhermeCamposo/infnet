package com.infnet.ejb;

import java.util.UUID;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.infnet.ejb.remoto.ControladorRemoto;

@Stateless
@Remote(ControladorRemoto.class)
public class Controlador implements ControladorRemoto{
		
	public String getSenha() {
		return UUID.randomUUID().toString();
	};
	
	
	
}
