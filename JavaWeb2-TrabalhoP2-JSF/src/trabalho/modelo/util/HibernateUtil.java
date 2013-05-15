package trabalho.modelo.util;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateUtil {


    
    private static final Session sessao ;

    static {
        try {
        	
        	Configuration conf =  new Configuration();
        	SessionFactory sessionFactory;
        	
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = conf.configure().buildSessionFactory();
            
            sessao = sessionFactory.openSession();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

	public static Session getSessao() {
		return sessao;
	}
    
    

}