package trabalho.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import trabalho.entidades.Agencia;

public class AgenciaDao extends Dao {

	public static void salvarAgencia(Agencia agencia) {
		EntityManagerFactory emf = getFactory();
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.merge(agencia);

		em.getTransaction().commit();

		em.close();
		emf.close();
	}

	public static void removerAgencia(Agencia agencia) {
		EntityManagerFactory emf = getFactory();
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.createQuery(
				" delete from Agencia where numero = " + agencia.getNumero())
				.executeUpdate();

		em.getTransaction().commit();

		em.close();
		emf.close();
	}

	public static Agencia buscarAgencia(int numero) {
		EntityManagerFactory emf = getFactory();
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Agencia agencia = (Agencia) em.createQuery(
				"Select a from Agencia a where a.numero =" + numero)
				.getSingleResult();

		em.getTransaction().commit();

		em.close();
		emf.close();
		return agencia;
	}

}
