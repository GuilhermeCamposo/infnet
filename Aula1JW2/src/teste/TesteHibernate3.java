package teste;

import java.util.Date;
import java.util.List;

import modelo.Pessoa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;

public class TesteHibernate3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{

		SessionFactory fabrica = HibernateUtil.getSessionFactory();
		Session sessao = fabrica.getCurrentSession();
		sessao.beginTransaction();
		
		List<Pessoa> lista = sessao.createQuery("from " + Pessoa.class.getName()).list();
		
		for (Pessoa pessoa : lista) 
		{
			System.out.println(pessoa);
		}
		
		sessao.getTransaction().commit();
	}

}
