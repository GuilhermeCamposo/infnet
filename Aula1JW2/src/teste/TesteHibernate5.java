package teste;

import java.util.Date;
import java.util.List;

import modelo.Pessoa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;

public class TesteHibernate5 {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		SessionFactory fabrica = HibernateUtil.getSessionFactory();
		Session sessao = fabrica.getCurrentSession();
		sessao.beginTransaction();

		//recupera um objeto específico. O id deve existir !!!
		Pessoa pessoa = (Pessoa)sessao.get(Pessoa.class, 30);
		System.out.println(pessoa);
		
		//salvando o bojeto no vanco de dados (equivalente ao update !!!)
		sessao.delete(pessoa);
		
		sessao.getTransaction().commit();
		
	}

}
