package com.ibytecode.businesslogic;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.Init;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloWorldBean
 * 
 * //@Stateful //@Remote(HelloWorldRemote.class)
 */

@Stateless
@LocalBean
public class HelloWorldBean implements HelloWorldRemote {

	private ArrayList<String> hellos;
	private static int count = 0;
	
    /**
     * Default constructor. 
     */	
    public HelloWorldBean() {
        hellos = new ArrayList<String>();
    }
    
    @Override
    public String sayHello() {        	
    	//return "Hello World :)";
    	hellos.add("Hello " + count++);
    	return hellos.toString();
    }

    @Init
	public void inicializar(){
		System.out.println("Inicializando...");
	}
	
	@PostConstruct
	public void criou(){
		System.out.println("Criou objeto...");
	}
}
