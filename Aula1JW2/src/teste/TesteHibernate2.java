package teste;

import java.util.Date;

import modelo.Pessoa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;

public class TesteHibernate2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		SessionFactory fabrica = HibernateUtil.getSessionFactory();
		Session sessao = fabrica.getCurrentSession();
		sessao.beginTransaction();
		
		
		for (int i = 0; i < 50; i++) 
		{
			Pessoa pessoa = new Pessoa("pessoa" + i,new Date(),"M",100);
			sessao.save(pessoa);
		}
		sessao.getTransaction().commit();
	}

}
