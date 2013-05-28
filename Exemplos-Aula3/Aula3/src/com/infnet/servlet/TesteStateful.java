package com.infnet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infnet.ejb.MeuStateful;

/**
 * Servlet implementation class TesteStateful
 */
@WebServlet("/TesteStateful")
public class TesteStateful extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private MeuStateful bean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TesteStateful() {
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
			out.println("<title>Servlet stateful</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1> Valor anterior " + bean.getNumero() + "</h1>");
			bean.setNumero(Integer.parseInt(request.getParameter("numero")));
			out.println("</body>");
			out.println("</html>");
		}finally{
			out.close();
		}
	}
	
}
