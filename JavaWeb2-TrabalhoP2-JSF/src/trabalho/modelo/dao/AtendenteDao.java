package trabalho.modelo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import trabalho.modelo.entidades.Atendente;
import trabalho.modelo.util.HibernateUtil;

public class AtendenteDao {

	private static AtendenteDao instance;
	private Session sessao;
	
	private AtendenteDao(){
	
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
	
	
	@SuppressWarnings("unchecked")
	public List<Atendente> buscarTodosAtendentes() {

		sessao =  HibernateUtil.getSessao();
		
		List<Atendente> lst = sessao.createCriteria(Atendente.class).list();
		
		return lst ;

	}
	
	
	
	public void cadastrarAtendente(Atendente atendente){
		
		sessao =   HibernateUtil.getSessao();
		sessao.beginTransaction();
						
        sessao.merge(atendente);
		
		sessao.getTransaction().commit();
	
		
	}
	
	
	public void deletarAtendente(Atendente atendente){
		
		sessao =   HibernateUtil.getSessao();

		sessao.beginTransaction();
	
		sessao.delete(atendente);
		
		sessao.getTransaction().commit();
		
	}


	
	
	
}
