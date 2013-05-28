package com.infnet.controller;

import javax.ejb.Remote;


@Remote
public interface FraseDoDia {
	
	String pegarFrase();
	
}
