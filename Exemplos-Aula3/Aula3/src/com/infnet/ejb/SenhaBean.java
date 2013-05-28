package com.infnet.ejb;

import java.util.UUID;

import javax.ejb.Stateless;


@Stateless
public class SenhaBean {

    public SenhaBean() {    
    }
    
    public String getSenha(){
    	return UUID.randomUUID().toString();
    }

}
