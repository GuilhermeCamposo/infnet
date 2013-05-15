package prova.modelo.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * classe utilitário para configuração do hibernate
 * 
 * @author Usuario
 * 
 */
public class HibernateUtil {

	private static final Session sessao;

	static {
		try {

			Configuration conf = new Configuration();
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

	/**
	 * devolve a sesão atualmente ativa
	 * 
	 * @return
	 */
	public static Session getSessao() {
		return sessao;
	}

}