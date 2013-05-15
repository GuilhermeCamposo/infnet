package prova.modelo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import prova.modelo.entidade.Produto;
import prova.modelo.util.HibernateUtil;

/**
 * classe de acesso a dados para a entidade produto
 * 
 * @author Usuario
 * 
 */
public class ProdutoDAO {

	private static ProdutoDAO instance;

	private Session sessao;

	private ProdutoDAO() {
	}

	public static ProdutoDAO getInstance() {
		if (instance == null) {
			instance = new ProdutoDAO();
		}
		return instance;
	}

	/**
	 * busca todos os produtos da base
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Produto> buscarTodosProdutos() {

		sessao = HibernateUtil.getSessao();

		return sessao.createCriteria(Produto.class).list();

	}

	/**
	 * busca o produto pela busca passada(nome) , se for vazia tras todos
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Produto> buscarProdutos(String busca) {

		sessao = HibernateUtil.getSessao();

		busca = busca.trim();

		if (busca.equals("")) {
			return buscarTodosProdutos();
		}

		List<Produto> lst = sessao.createCriteria(Produto.class)
				.add(Restrictions.like("nome", "%" + busca + "%")).list();

		return lst;
	}

	@SuppressWarnings("unchecked")
	public Produto buscarProduto(int idProduto) {

		sessao = HibernateUtil.getSessao();

		List<Produto> lst = sessao.createCriteria(Produto.class)
				.add(Restrictions.eq("id", idProduto)).list();

		if (lst.isEmpty()) {
			return null;
		} else {
			return lst.get(0);
		}

	}

}
