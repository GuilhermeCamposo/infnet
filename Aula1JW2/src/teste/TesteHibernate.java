package teste;

import java.util.Date;

import modelo.Pessoa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;

public class TesteHibernate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		SessionFactory fabrica = HibernateUtil.getSessionFactory();
		Session sessao = fabrica.getCurrentSession();
		sessao.beginTransaction();
		
		Pessoa pessoa = new Pessoa("Josué",new Date(),"M",100);
		
		sessao.save(pessoa);
		
		sessao.getTransaction().commit();
	}

}
