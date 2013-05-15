package com.infnet.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infnet.jms.ProdutorDeMensagem;
import com.infnet.pojo.Usuario;

/**
 * Servlet implementation class ServletCriaMensagem
 */
@WebServlet("/ServletCriaMensagem")
public class ServletCriaMensagem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ProdutorDeMensagem produtorDeMensagem;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>>>> Criando mensagem de teste...");
		produtorDeMensagem.enviarMensagem(new Usuario("Ulisses"));
	}

//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}

}
