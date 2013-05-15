package trabalho.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Dao {

	public static EntityManagerFactory getFactory(){
		return Persistence.createEntityManagerFactory("TrabalhoP2-JavaEnterprise1");
	}
	
}
