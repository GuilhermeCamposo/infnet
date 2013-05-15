package trabalho.modelo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import trabalho.modelo.entidades.Medico;
import trabalho.modelo.util.HibernateUtil;

public class MedicoDao {

	private static MedicoDao instance;
	private Session sessao;

	private MedicoDao() {

	}

	public static MedicoDao getInstance() {
		if (instance == null) {
			instance = new MedicoDao();
		}

		return instance;
	}

	/**
	 * busca um médico por sua matrícula , caso não seja encontrado retorna null
	 * .
	 * 
	 * @param matricula
	 * @return
	 */
	public Medico buscarMedico(int matricula) { 
		
		sessao = HibernateUtil.getSessao();
		sessao.beginTransaction();

		return (Medico) sessao.createCriteria(Medico.class).
				add(Restrictions.eq("matricula", matricula)).list().get(0);

	}

	@SuppressWarnings("unchecked")
	public List<Medico> buscarTodosMedicos() {

		sessao = HibernateUtil.getSessao();

		sessao.beginTransaction();

		return sessao.createCriteria(Medico.class).list();

	}

	/**
	 * salva um novo médico ou as alterações feita a um já existente
	 * @param medico
	 */
	public void cadastrarMedico(Medico medico) {

		sessao = HibernateUtil.getSessao();
		sessao.beginTransaction();

		sessao.merge(medico);

		sessao.getTransaction().commit();

	}

	public void deletarMedico(Medico medico) {

		sessao = HibernateUtil.getSessao();

		sessao.beginTransaction();

		sessao.delete(medico);

		sessao.getTransaction().commit();

	}
}
