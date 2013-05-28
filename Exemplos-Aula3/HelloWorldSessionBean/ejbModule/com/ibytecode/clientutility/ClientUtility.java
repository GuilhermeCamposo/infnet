/**
 * 
 */
package com.ibytecode.clientutility;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class ClientUtility {
	private static Context initialContext;
	
//	private static final String PKG_INTERFACES = "org.jboss.ejb.client.naming"; 	
	
	private static final String PKG_INTERFACES = "java.naming.factory.initial";
	
	public static Context getInitialContext() throws NamingException{
		if(initialContext == null){
			Properties props = new Properties();
			props.put(Context.URL_PKG_PREFIXES, PKG_INTERFACES);
			initialContext = new InitialContext(props); 
		}
		return initialContext;
	}
}
