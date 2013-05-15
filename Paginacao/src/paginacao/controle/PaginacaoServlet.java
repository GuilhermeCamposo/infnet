package paginacao.controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paginacao.modelo.dao.NomeDAO;
import paginacao.modelo.entidade.Nome;

/**
 * Servlet implementation class PaginacaoServlet
 */
@WebServlet("/PaginacaoServlet")
public class PaginacaoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	NomeDAO dao = null;

	@Override
	public void init() throws ServletException {

		super.init();

		try {
			dao = NomeDAO.getInstance();
		} catch (Exception e) {
			System.out.println("Erro ao busca instância do DAO");
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			
				String indice = request.getParameter("indice");
				mostrarTabela(response , Integer.parseInt(indice));
	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("acao") != null) {
			Nome nome = new Nome();
			nome.setNome(request.getParameter("texto"));
			try {
				dao.incluir(nome);
				response.sendRedirect("index.html");
			} catch (Exception e) {
				System.out.println("erro ao inserir nome na tabela");
			}
		}

	}

/**
 * cria a tabela e mostra de acordo com o indice passado
 * @param response
 * @param indice
 * @throws IOException
 */
	private void mostrarTabela(HttpServletResponse response, int indice)
			throws IOException {

		List<Nome> nomes = new ArrayList<Nome>();
		try {
			nomes = dao.listar();
		} catch (Exception e) {
			System.out.println("Erro ao carregar lista de nomes");
		}

		int numPaginas;
		if (nomes.size() % 10 != 0) {
			numPaginas = (nomes.size() / 10) + 1;
		} else {
			numPaginas = (nomes.size() / 10);
		}

		PrintWriter out = response.getWriter();

		out.print("<html><head><title>Insert title here</title></head><body>");
		out.print("<h1>Tabela de nomes inseridos</h1>");
		int contador;
		if (indice == 1 ||indice == 0) {
			contador = 0;
			indice = 1 ;
		} else {
			contador = ( (indice-1) * 10) - 1;
		}
		int i = 0;
         
		out.print("<table border='1'>");
		while (i < 10) {
			
			if (contador + i < nomes.size()) {
				Nome linha = nomes.get(contador + i);
				out.print("<tr> <td>");
				out.print(linha.getId() + "</td>");
				out.print("<td>" + linha.getNome() + "</td></tr>");
			}
			i++;
		}
		out.print("<table border='1'>");
		
		if (indice == 1 ||indice == 0) {		
			out.print("<a href='PaginacaoServlet?indice="+(indice+1)+"'> Próximo </a>");
		}else{
			if (indice == numPaginas) {
				out.print("<a href='PaginacaoServlet?indice="+(indice-1)+"'> Anterior </a>");
			}else{
				out.print("<a href='PaginacaoServlet?indice="+(indice-1)+"'> Anterior </a>");
				out.print("<a href='PaginacaoServlet?indice="+(indice+1)+"'> Próximo </a>");
			}
		}
		
		out.print("<br><a href='index.html'> Voltar </a>");
		
		
	}

}
