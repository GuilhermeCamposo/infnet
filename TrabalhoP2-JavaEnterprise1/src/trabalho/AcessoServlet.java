package trabalho;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trabalho.dao.AgenciaDao;
import trabalho.dao.ClienteDao;
import trabalho.dao.ContaDao;
import trabalho.dao.MovimentoDao;
import trabalho.entidades.Agencia;
import trabalho.entidades.Cliente;
import trabalho.entidades.Conta;
import trabalho.entidades.ContaEspecial;
import trabalho.entidades.Movimento;

import com.google.gson.Gson;

/**
 * Servlet implementation class AcessoServlet
 */
@WebServlet("/AcessoServlet")
public class AcessoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public AcessoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter();

		String entidade = request.getParameter("entidade");
		String acao = request.getParameter("acao");

		switch (entidade) {
		case "agencia":
			acaoAgencia(acao, writer);
			break;

		case "cliente":
			acaoCliente(acao, writer);
			break;

		case "conta":
			acaoConta(acao, writer);
			break;

		case "movimento":
			acaoMovimento(acao, writer);
			break;

		case "especial":
			acaoContaEspecial(acao, writer);
			break;

		}

		writer.flush();
		writer.close();
	}

	/**
	 * 
	 * @param acao
	 * @param writer
	 */
	private void acaoCliente(String acao, PrintWriter writer) {
		switch (acao) {
		case "del":
			Cliente cliente = new Cliente();
			cliente.setId(2);
			ClienteDao.removerCliente(cliente);
			writer.write("<html><body>Cliente removido com sucesso</body></html>");
			break;

		case "add":
			cliente = new Cliente();
			cliente.setNome("Guilherme");
			ClienteDao.salvarCliente(cliente);
			writer.write("<html><body>Cliente salvo com sucesso</body></html>");
			break;
			
		case "srch":
			cliente = ClienteDao.buscarCliente(1);
			writer.write("<html><body>Cliente"+new Gson().toJson(cliente)+"</body></html>");
			break;
		}
	}

	/**
	 * 
	 * @param acao
	 * @param writer
	 */
	private void acaoAgencia(String acao, PrintWriter writer) {

		switch (acao) {
		case "del":
			Agencia agencia = new Agencia();
			agencia.setNumero(2);
			AgenciaDao.removerAgencia(agencia);
			writer.write("<html><body>Agencia removida com sucesso</body></html>");
			break;

		case "add":
			agencia = new Agencia();
			agencia.setEndereco("Rua do mercado, 1");
			AgenciaDao.salvarAgencia(agencia);
			writer.write("<html><body>Agência salvo com sucesso</body></html>");
			break;
		}
	}

	/**
	 * 
	 * @param acao
	 * @param writer
	 */
	private void acaoMovimento(String acao, PrintWriter writer) {

		Movimento movimento = new Movimento();
		switch (acao) {
		case "del":
			MovimentoDao.removerMovimento(1);
			writer.write("<html><body>Movimento salvo com sucesso</body></html>");
			break;

		case "add":

			movimento.setConta(ContaDao.buscarConta(1));
			movimento.setData(new Timestamp(new Date().getTime()));
			movimento.setValor(2000.00);

			MovimentoDao.salvarMovimento(movimento);
			
			writer.write("<html><body>Movimento salvo com sucesso</body></html>");
			
			break;
		case "srch":

			movimento = MovimentoDao.buscarMovimento(1);

			writer.write("<html><body> Movimento " + new Gson().toJson(movimento)
					+ "<body/> <hmtl/>");

			break;
		}
	}

	/**
	 * 
	 * @param acao
	 * @param writer
	 */
	private void acaoConta(String acao, PrintWriter writer) {
		
		Conta conta = new Conta();
		
		switch (acao) {
		case "del":

			ContaDao.removerConta(2);
			writer.write("<html><body>Conta deletada com sucesso</body></html>");
			
			break;

		case "add":
			conta.setAgencia(AgenciaDao.buscarAgencia(1));
			
			HashSet<Cliente> clientes = new HashSet<>();
			clientes.add(ClienteDao.buscarCliente(1));
			
			
			conta.setClientes(clientes);

			ContaDao.salvarConta(conta);		
			writer.write("<html><body>Conta salvo com sucesso</body></html>");
			break;
		}
	}

	/** 
	 * 
	 * 
	 */
	private void acaoContaEspecial(String acao, PrintWriter writer) {

		ContaEspecial conta = new ContaEspecial();
		switch (acao) {
		case "del":
 
			ContaDao.removerConta(2);
			writer.write("<html><body>Conta Especial deletada com sucesso</body></html>");
			
			break;

		case "add":

			conta.setAgencia(AgenciaDao.buscarAgencia(1));
			conta.setLimiteExtra(25000.50);
			
			HashSet<Cliente> clientes = new HashSet<>();
			clientes.add(ClienteDao.buscarCliente(1));
			
			conta.setClientes(clientes);

			ContaDao.salvarConta(conta);
			
			writer.write("<html><body>Conta Especial salva com sucesso</body></html>");

			break;
		}
	}

}
