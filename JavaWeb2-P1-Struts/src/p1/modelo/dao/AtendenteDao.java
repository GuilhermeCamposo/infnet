package p1.modelo.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;

import p1.modelo.entidades.Atendente;
import p1.modelo.util.HibernateUtil;

public class AtendenteDao {

	private static AtendenteDao instance;
	private StatelessSession sessao;
	
	private AtendenteDao(){
		
		SessionFactory fabrica = HibernateUtil.getSessionFactory();
		sessao = fabrica.openStatelessSession();
	}
	
	public static AtendenteDao getInstance() {
		if (instance == null) {
			instance = new AtendenteDao();
		}

		return instance;
	}
	
	/**
	 * busca um atendete por sua matrícula , caso não seja encontrado retorna null .
	 * @param matricula
	 * @return
	 */
	public Atendente  buscarAtendente( int matricula ){
		
		Query query =	sessao.createQuery("select m from  Atendente as m where funcionario.matricula ="+ matricula);
		

		if (query.list().isEmpty()) {
			return null;
		}

		return (Atendente) query.list().get(0);

		
	}


	
	
	
}
