package com.ativa.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtils {

	private  final SessionFactory sessionFactory;
	private Session sessao;
	private static  HibernateUtils instance;
	
	
	public static  HibernateUtils getInstance() {
		
		if (instance == null) {
			instance = new HibernateUtils();
			new Mock();
		}
		
		return instance;
	}

	private HibernateUtils() {
		try {
              
			Configuration cfg = new Configuration();
			cfg.configure();
			
			ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder().applySettings(cfg.getProperties());
			ServiceRegistry serviceRegistry = serviceRegistryBuilder.buildServiceRegistry();
			
			sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public  Session getSession() {
		
		if (sessao == null || !sessao.isOpen()) {
			sessao = sessionFactory.openSession();
		}
		return sessao;
	}

	
	public  void closeSession(){
		if (sessao != null && sessao.isOpen()) {
			sessao.close();
		}
	}

}
