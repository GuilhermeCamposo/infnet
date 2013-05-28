package com.infnet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infnet.ejb.MeuSingleton;
import com.infnet.ejb.MeuStateful;

/**
 * Servlet implementation class AcessaSingleton2
 */
@WebServlet("/AcessaSingleton2")
public class AcessaSingleton2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@EJB
	private MeuSingleton beanSingleton;
	
	@EJB
	private MeuStateful beanStateful;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcessaSingleton2() {
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
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet Singleton</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1> Valor do bean singleton " + beanSingleton.getEstado() + "</h1>");			
			out.println("<h1> Valor do bean stateful " + beanStateful.getNumero() + "</h1>");			
			out.println("</body>");
			out.println("</html>");
		}finally{
			out.close();
		}
	}
	
}
