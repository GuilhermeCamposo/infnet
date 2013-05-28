package com.ibytecode.client;

import javax.naming.Context;
import javax.naming.NamingException;

import com.ibytecode.businesslogic.HelloWorldBean;
import com.ibytecode.businesslogic.HelloWorldRemote;
import com.ibytecode.clientutility.ClientUtility;

public class EJBApplicationClient {
	
	
	private static HelloWorldRemote doLookup() {
		Context context = null;
		HelloWorldRemote bean = null;

		try {
			// 1 - obtem o contexto
			context = ClientUtility.getInitialContext();

			// 2 - gera o nome para busca JNDI
			String lookupName = getLookupName();
			
			System.out.println(lookupName);
			
			// 3 - faz a busca e a coercao
			bean = (HelloWorldRemote) context.lookup(lookupName);

		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		return bean;
	}

	private static String getLookupName() {
		/*
		 * o nome da aplicacao È o nome do ear do EJB implementado ('deployado')
		 * sem o sufxo ear
		 */
		String appName = "";

		/*
		 * O nome do modulo È o nome do JAR do EJB implementado sem o sufixo
		 * .jar
		 */
		String moduleName = "HelloWorldSessionBean";

		/*
		 * O JBAS 7 permite que cada deploy tenha um nome distinto (opcional).
		 */
		String distinctName = "";

		// O nome da classe de implementaÁ„o do bean
		String beanName = HelloWorldBean.class.getSimpleName();

		final String interfaceName = HelloWorldRemote.class.getName();

		//String name = "ejb:" + appName + "/" + moduleName + "/" + distinctName	+ "/" + beanName + "!" + interfaceName;
		String name = "java:global" + appName + "/" + moduleName 	+ "/" + beanName + "!" + interfaceName;
		
		//Na aplicaçao anterior
		//ejb:/HelloWorldSessionBean//HelloWorldBean!com.ibytecode.businesslogic.HelloWorldRemote
		
		//no JBOSS
		//java:global/HelloWorldSessionBean/HelloWorldBean!com.ibytecode.businesslogic.HelloWorldBean
		
//		String name = "ejb:" + appName + "/" + moduleName + "/" + distinctName
//				+ "/" + beanName + "!" + interfaceName + "?stateful";

		return name;

	}
	
	public static void main(String[] args){
		HelloWorldRemote bean = doLookup();
		System.out.println(bean.sayHello()); //chama a logica de negocio
		System.out.println(bean.sayHello()); 
		System.out.println(bean.sayHello());
	}
}
