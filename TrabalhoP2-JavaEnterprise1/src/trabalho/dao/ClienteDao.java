package trabalho.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import trabalho.entidades.Cliente;

public class ClienteDao extends Dao {

	public static void salvarCliente(Cliente cliente) {
		EntityManagerFactory emf = getFactory();
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.merge(cliente);

		em.getTransaction().commit();

		em.close();
		emf.close();
		
	}

	public static void removerCliente(Cliente cliente) {
		EntityManagerFactory emf = getFactory();
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.createQuery(
				" delete from Cliente where id = " + cliente.getId())
				.executeUpdate();

		em.getTransaction().commit();

		em.close();
		emf.close();
		
	}

	public static Cliente buscarCliente(int id) {
		EntityManagerFactory emf = getFactory();
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Cliente cliente = (Cliente) em.createQuery(
				"Select c from Cliente c where c.id =" + id)
				.getSingleResult();

		em.getTransaction().commit();

		em.close();
		emf.close();
		return cliente;
	}

}
