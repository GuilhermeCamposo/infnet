package com.tarefajavap2.service;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tarefajavap2.interfaces.IServidor;
import com.tarefajavap2.util.ConnectionManager;
/**
 * Classe que disponibiliza o servico de geracao de relatorios
 *
 */
public class Servidor extends UnicastRemoteObject implements IServidor{
	private ResultSet rs = null;
	
	
	public Servidor() throws RemoteException {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 9142274716810977210L;
	
	/**
	 * Metodo que monta o rmi para disponibilizar o metodo de entrada dos clientes.
	 */
	private static void montaRMI(){
		try {

			Servidor serv = new Servidor();

			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind("servidor", serv);

			System.out.println("servidor no ar...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) throws RemoteException {
		montaRMI();
	}

	/**
	 * Valida se o nome do cliente possui movimentos e retorna true ou false.
	 * Se true gerar o relatorio atraves da Thread.
	 */
	@Override
	public Boolean pedidoRelatorio(String nome,String ipCliente) {
		
		Boolean flagClienteValido;
		//Validar o nome do cliente no banco, buscando seus dados
		if(flagClienteValido = buscaEValidaRelatorioCliente(nome)){
			Runnable trataPedido = new TrataPedidoRelatorioService(ipCliente,rs);
			Thread t = new Thread(trataPedido);
			t.start();
		}
		return flagClienteValido;
	}

/**
 * Busca o relatorio do cliente e preenche o ResultSet
 * @param nome
 * @return
 */
	private boolean buscaEValidaRelatorioCliente(String nome) {
		
		String sql = "select * from movimento where nome = '"+nome+"'";
		Connection conn = null;
		try {
			conn = ConnectionManager.getInstance().getConnection();
					
		    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);  
		    rs = stmt.executeQuery(sql);
			
			boolean retorno = rs.next();
			rs.beforeFirst();
			
			return (retorno);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}
