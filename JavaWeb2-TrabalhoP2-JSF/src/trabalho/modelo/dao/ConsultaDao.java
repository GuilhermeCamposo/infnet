package trabalho.modelo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import trabalho.modelo.entidades.Atendente;
import trabalho.modelo.entidades.Consulta;
import trabalho.modelo.entidades.Medico;
import trabalho.modelo.entidades.Paciente;
import trabalho.modelo.util.HibernateUtil;

public class ConsultaDao {

	private static ConsultaDao instance;
	private Session sessao;

	private ConsultaDao() {

	}

	public static ConsultaDao getInstance() {
		if (instance == null) {
			instance = new ConsultaDao();
		}
		return instance;
	}

	public void agendarConsulta(Integer idMedico, Integer idAtendente,
			String cpfPaciente) {

		sessao =  HibernateUtil.getSessao();

		sessao.beginTransaction();

		Medico medico = (Medico) sessao.get(Medico.class, idMedico);
		Atendente atendente = (Atendente) sessao.get(Atendente.class,
				idAtendente);

		Paciente paciente = (Paciente) sessao.createCriteria(Paciente.class)
				.add(Restrictions.like("cpf", cpfPaciente)).list().get(0);

		Consulta consulta = new Consulta();

		consulta.setAtendente(atendente);
		consulta.setMedico(medico);
		consulta.setPaciente(paciente);

		sessao.save(consulta);

		sessao.getTransaction().commit();

	}

	/**
	 * busca a primeira  consulta agendada não atendida
	 * 
	 * @return
	 */
	public Consulta buscarConsulta() {

		sessao =  HibernateUtil.getSessao();
		sessao.beginTransaction();

		@SuppressWarnings("unchecked")
		List<Consulta> lstConsultas = sessao.createCriteria(Consulta.class)
				.add(Restrictions.eq("status", false)).list();

		if (lstConsultas.size() > 0) {
			return lstConsultas.get(0);
		}

		return null;
	}
  
	
	/**
	 * busca a primeira  consulta agendada não atendida
	 * 
	 * @return
	 */
	public Consulta buscarConsultaPorMedico(Medico medico) {

		sessao =  HibernateUtil.getSessao();
		sessao.beginTransaction();

		@SuppressWarnings("unchecked")
		List<Consulta> lstConsultas = sessao.createCriteria(Consulta.class)
				.add(Restrictions.eq("status", false))
			    .add(Restrictions.eq("medico", medico))
				.list();

		if (lstConsultas.size() > 0) {
			return lstConsultas.get(0);
		}

		return null;
	}
	
	
	
	public void finalizarConsulta(Consulta consulta){
		
		sessao =  HibernateUtil.getSessao();
		sessao.beginTransaction();
		
		consulta.setStatus(true);
		
		sessao.save(consulta);

		
		sessao.getTransaction().commit();
		
		
	}
	
	
}
