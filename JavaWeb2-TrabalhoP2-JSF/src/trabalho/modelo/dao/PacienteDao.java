package trabalho.modelo.dao;

import java.util.List;

import org.hibernate.Session;

import trabalho.modelo.entidades.Paciente;
import trabalho.modelo.util.HibernateUtil;

public class PacienteDao {

	private Session sessao;
	private static PacienteDao instance;

	private PacienteDao() {
	}

	public static PacienteDao getInstance() {
		if (instance == null) {
			instance = new PacienteDao();
		}

		return instance;
	}
	
	
	public void cadastrarPaciente(Paciente paciente){
		
		sessao =   HibernateUtil.getSessao();

		sessao.beginTransaction();
		
		sessao.save(paciente);
		
		sessao.getTransaction().commit();
		
	}

	
	public Paciente buscarPaciente() {
		sessao =  HibernateUtil.getSessao();

		sessao.beginTransaction();	

		@SuppressWarnings("unchecked")
		List<Paciente> funcList = sessao.createCriteria(Paciente.class)
			    .list();
		

		return funcList.get(0);

	}
	
}
