package trabalho.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import trabalho.entidades.Movimento;

public class MovimentoDao extends Dao {

	public static void salvarMovimento(Movimento movimento) {
		EntityManagerFactory emf = getFactory();
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.merge(movimento);

		em.getTransaction().commit();

		em.close();
		emf.close();
		
	}

	public static void removerMovimento(int codigo) {
		EntityManagerFactory emf = getFactory();
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.createQuery(
				" delete from Movimento where codigo = " + codigo)
				.executeUpdate();

		em.getTransaction().commit();

		em.close();
		emf.close();		
	}

	
	public static Movimento buscarMovimento(int codigo) {
		EntityManagerFactory emf = getFactory();
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Movimento movimento = (Movimento) em.createQuery(
				"Select a from Movimento a where a.codigo =" + codigo)
				.getSingleResult();

		em.getTransaction().commit();

		em.close();
		emf.close();
		return movimento;
		
	}

	
	
}
