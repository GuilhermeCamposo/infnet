package com.ibytecode.businesslogic;

import javax.ejb.Remote;

@Remote
public interface HelloWorldRemote {

	public String sayHello();
	
}
