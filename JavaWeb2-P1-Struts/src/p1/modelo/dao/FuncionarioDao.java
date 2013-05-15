package p1.modelo.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;

import p1.modelo.entidades.Funcionario;
import p1.modelo.util.HibernateUtil;

public class FuncionarioDao {

	private static FuncionarioDao instance;
	private StatelessSession sessao;

	private FuncionarioDao() {

		SessionFactory fabrica = HibernateUtil.getSessionFactory();
		sessao = fabrica.openStatelessSession();
	}

	public static FuncionarioDao getInstance() {
		if (instance == null) {
			instance = new FuncionarioDao();
		}
		return instance;
	}

	/**
	 * busca o funcionario pela senha e login
	 * 
	 * @param senha
	 * @param login
	 * @return
	 */
	public Funcionario buscarFuncionario(String senha, String login) {

		sessao.beginTransaction();

		Query query = sessao
				.createQuery("select f from Funcionario as f  where f.senha like '"
						+ senha + "' and f.login like '" + login + "'");

		if (query.list().isEmpty()) {
			return null;
		}

		return (Funcionario) query.list().get(0);

	}

}
