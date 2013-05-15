package trabalho.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import trabalho.entidades.Conta;

public class ContaDao extends Dao{

	public static void salvarConta(Conta conta) {
		EntityManagerFactory emf = getFactory();
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.merge(conta);

		em.getTransaction().commit();

		em.close();
		emf.close();
	}
	
	public static void removerConta(int numeroConta) {
		EntityManagerFactory emf = getFactory();
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.createQuery("delete from Conta where numero="+numeroConta).executeUpdate();

		em.getTransaction().commit();

		em.close();
		emf.close();
	}

	public static Conta buscarConta(int numeroConta) {
		EntityManagerFactory emf = getFactory();
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Conta conta = (Conta)em.createQuery("Select c  from Conta c where c.numero="+numeroConta).getSingleResult();

		em.getTransaction().commit();

		em.close();
		emf.close();
		
		return conta;
	}



	

}
