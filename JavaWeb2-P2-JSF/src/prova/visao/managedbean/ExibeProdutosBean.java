package prova.visao.managedbean;

import java.util.List;

import javax.faces.component.UIData;

import prova.modelo.dao.ProdutoDAO;
import prova.modelo.entidade.Produto;
/**
 * bean responsável pela visão dos produtos para os clientes
 * @author Usuario
 *
 */
public class ExibeProdutosBean {

	private List<Produto> produtos;
	private Produto prodSelecionado;
	private String busca;
	private UIData tabela;

	public ExibeProdutosBean() {
		produtos = ProdutoDAO.getInstance().buscarTodosProdutos();
	}

	/**
	 * busca o produto pelo nome de acordo com o que foi passado no campo de busca
	 * @return
	 */
	public String buscarProdutos() {

		produtos = ProdutoDAO.getInstance().buscarProduto(busca);

		return null;

	}

	/**
	 * pega o campo de busca e o detalha em outra tela
	 * @return
	 */
	public String detalharProduto() {

		prodSelecionado = (Produto) tabela.getRowData();

		return "detalhe";
	}

	public UIData getTabela() {
		return tabela;
	}

	public void setTabela(UIData tabela) {
		this.tabela = tabela;
	}

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto getProdSelecionado() {
		return prodSelecionado;
	}

	public void setProdSelecionado(Produto prodSelecionado) {
		this.prodSelecionado = prodSelecionado;
	}

}
