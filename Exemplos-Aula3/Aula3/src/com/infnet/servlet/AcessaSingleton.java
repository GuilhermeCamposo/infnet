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

/**
 * Servlet implementation class AcessaSingleton
 */
@WebServlet("/AcessaSingleton")
public class AcessaSingleton extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private MeuSingleton bean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcessaSingleton() {
        super();        
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
			out.println("<h1> Valor do bean " + bean.getEstado() + "</h1>");
			bean.setEstado(15);
			out.println("</body>");
			out.println("</html>");
		}finally{
			out.close();
		}
	}

}
