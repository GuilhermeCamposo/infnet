package teste;

import java.util.Date;

import modelo.Endereco;
import modelo.Pessoa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;

public class TesteHibernate6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		SessionFactory fabrica = HibernateUtil.getSessionFactory();
		Session sessao = fabrica.getCurrentSession();
		sessao.beginTransaction();
		
		Pessoa pessoa = new Pessoa("Josué",new Date(),"M",100);
		
		Endereco endResidencial = new Endereco("rua érico coleho", "ilha", "residencial");
		Endereco endComercial   = new Endereco("rua buenos aires", "centro", "comercial");
		Endereco endOutro       = new Endereco("rua das araras", "rio de janeiro", "outro");
		
		sessao.save(endResidencial);
		sessao.save(endComercial);
		sessao.save(endOutro);
		
		pessoa.adicionar(endResidencial);
		pessoa.adicionar(endComercial);
		pessoa.adicionar(endOutro);
		
		sessao.save(pessoa);
		sessao.getTransaction().commit();
	}

}
