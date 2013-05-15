package com.tarefajavap2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Classe que fornece a conexao com o banco de dados
 *
 */
public class ConnectionManager {
	private static final String url = "jdbc:postgresql://localhost:5432/movimento";
	private static final String login = "postgres";
	private static final String pwd = "guilherme";
	
	private static ConnectionManager instance = null;

	private ConnectionManager(){
		
	}
	/**
	 * Retorna uma conexao com o banco de dados
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, login, pwd);
	}
	
	
	public static ConnectionManager getInstance() {
		if(instance == null){
			instance = new ConnectionManager();
		}
		return instance;
	}
}
