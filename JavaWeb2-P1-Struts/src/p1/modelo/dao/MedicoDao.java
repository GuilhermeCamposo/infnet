package p1.modelo.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;

import p1.modelo.entidades.Medico;
import p1.modelo.util.HibernateUtil;

public class MedicoDao {

	private static MedicoDao instance;
	private StatelessSession sessao;

	private MedicoDao() {

		SessionFactory fabrica = HibernateUtil.getSessionFactory();
		sessao = fabrica.openStatelessSession();
	}

	public static MedicoDao getInstance() {
		if (instance == null) {
			instance = new MedicoDao();
		}

		return instance;
	}
	
	/**
	 * busca um médico por sua matrícula , caso não seja encontrado retorna null .
	 * @param matricula
	 * @return
	 */
	public Medico  buscarMedico( int matricula ){
		
		Query query =	sessao.createQuery("select m from  Medico as m where funcionario.matricula ="+ matricula);
		

		if (query.list().isEmpty()) {
			return null;
		}

		return (Medico) query.list().get(0);

		
	}

}
