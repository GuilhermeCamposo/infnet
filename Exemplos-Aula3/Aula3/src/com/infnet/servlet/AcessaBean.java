package com.infnet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infnet.ejb.SenhaBean;

/**
 * Servlet implementation class AcessaBean
 */
@WebServlet("/AcessaBean")
public class AcessaBean extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	@EJB
	private SenhaBean bean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcessaBean() {
        super();        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processa(response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processa(response.getWriter());
	}

	private void processa(PrintWriter out){
		out.println("<html><head><title>Servlet chamando o EJB </title></head><body>");
		out.println("<br/>UUID gerado: " + bean.getSenha());
		out.println("</body></html>");
	}
		
}
