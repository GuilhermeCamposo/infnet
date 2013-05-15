package trabalho.modelo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import trabalho.modelo.entidades.Funcionario;
import trabalho.modelo.util.HibernateUtil;

public class FuncionarioDao {

	private static FuncionarioDao instance;
	private Session sessao;

	private FuncionarioDao() {

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
	@SuppressWarnings("unchecked")
	public Funcionario buscarFuncionario(String senha, String login) {

		sessao = HibernateUtil.getSessao();

		sessao.beginTransaction();

		List<Funcionario> funcList = sessao.createCriteria(Funcionario.class)
				.add(Restrictions.like("senha", senha))
				.add(Restrictions.like("login", login)).list();

		Funcionario funcionario = null;
		
		if (!funcList.isEmpty()) {
			funcionario = funcList.get(0);
		}

		return funcionario;
	}

	public void salvarFuncionario(Funcionario funcionario) {

		sessao = HibernateUtil.getSessao();

		sessao.beginTransaction();

		sessao.save(funcionario);

		sessao.getTransaction().commit();

	}

}
