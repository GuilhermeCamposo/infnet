package client;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ValidatorBeanLocal;

/**
 * Servlet implementation class ValidacaoServlet
 */
@WebServlet("/ValidacaoServlet")
public class ValidacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	ValidatorBeanLocal bean;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("cpf") != null) {

			String cpf = request.getParameter("cpf");

			Boolean valido = bean.validarCPF(cpf);

			request.setAttribute("valido", valido);
			response.sendRedirect("index.jsp");

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("cpf") != null) {

			String cpf = request.getParameter("cpf");

			Boolean valido = bean.validarCPF(cpf);

			request.setAttribute("valido", valido);
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
			rd.forward(request, response);

		}

	}

}
