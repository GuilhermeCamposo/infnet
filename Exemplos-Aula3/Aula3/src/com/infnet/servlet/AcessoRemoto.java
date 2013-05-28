package com.infnet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infnet.ejb.remoto.ControladorRemoto;

/**
 * Servlet implementation class AcessoRemoto
 */
@WebServlet("/AcessoRemoto")
public class AcessoRemoto extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	@EJB
//	private ControladorRemoto beanRemoto;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcessoRemoto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try{
			InitialContext ctx = new InitialContext();
			ControladorRemoto beanRemoto = (ControladorRemoto) ctx.lookup("java:global/Aula3/Controlador");			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet Singleton</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1> Usando JNDI </h1>");
			out.println("<h1> Senha obtida remotamente " + beanRemoto.getSenha() + "</h1>");								
			out.println("</body>");
			out.println("</html>");
		} catch (NamingException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}

	
}
